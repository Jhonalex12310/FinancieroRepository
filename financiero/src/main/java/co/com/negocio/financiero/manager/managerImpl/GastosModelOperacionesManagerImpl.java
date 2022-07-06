package co.com.negocio.financiero.manager.managerImpl;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.com.negocio.financiero.facade.LoggerFacade;
import co.com.negocio.financiero.manager.GastosModelManager;
import co.com.negocio.financiero.manager.GastosModelOperacionesManager;
import co.com.negocio.financiero.model.dto.BalanceUsuarioModelDTO;
import co.com.negocio.financiero.model.dto.GastosModelDTO;
import co.com.negocio.financiero.model.dto.ParametrosModelDTO;
import co.com.negocio.financiero.model.dto.UsuariosModelDTO;
import co.com.negocio.financiero.utilidades.ConversorPesos;
import co.com.negocio.financiero.utilidades.GastosModelUtil;

@Service
@Transactional
public class GastosModelOperacionesManagerImpl implements GastosModelOperacionesManager {	
	
	@Autowired
	private LoggerFacade lLoggerFacade;
	
	@Autowired
	@Qualifier(value="GastosModelManagerUsuariosImpl")
	private GastosModelManager lGastosModelManagerUsuarios;
	
	@Autowired
	@Qualifier(value="GastosModelManagerParametrosImpl")
	private GastosModelManager lGastosModelManagerParametros;

	@Autowired
	@Qualifier(value="GastosModelManagerImpl")
	private GastosModelManager lGastosModelManagerImpl;
	
	@Autowired	
	private ConversorPesos lConversorPesos;	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<BalanceUsuarioModelDTO> obtenerBalanceGeneral(String pUsuario) throws Exception {

		ArrayList<BalanceUsuarioModelDTO> lGastosModelBalanceUsuarioDTO = new ArrayList<BalanceUsuarioModelDTO>();
		ArrayList<UsuariosModelDTO> lGastosModelUsuarioDTO = new ArrayList<UsuariosModelDTO>();
		ArrayList<ParametrosModelDTO> lGastosModelParametrosDTO = new ArrayList<ParametrosModelDTO>();
		ArrayList<GastosModelDTO> lGastosModelDTO = new ArrayList<GastosModelDTO>();
		
		int lTamanioArreglo = 0 ;
		try {
			
			lLoggerFacade.insertarError(this.getClass().getName(), GastosModelUtil.UtilitiesGeneral.ERROR_CONSULTA_GENERICO, null);
			
			lGastosModelUsuarioDTO = (ArrayList<UsuariosModelDTO>) lGastosModelManagerUsuarios.consultarRegistros(null, null, pUsuario);
			
			if(lGastosModelUsuarioDTO.size() > 0) {
				
				lGastosModelParametrosDTO = (ArrayList<ParametrosModelDTO>) lGastosModelManagerParametros.consultarRegistros(null, null, pUsuario);
				
				if (lGastosModelParametrosDTO.size()>0) {
					
					BigDecimal lCalculoTotal = new BigDecimal(0);
					BalanceUsuarioModelDTO lDetalles = new BalanceUsuarioModelDTO();
					lDetalles.setDescripcion(GastosModelUtil.UtilitiesGeneral.CONCEPTO_SALARIO);
					lDetalles.setValorCalculado(lGastosModelUsuarioDTO.get(0).getSalario());
					lGastosModelBalanceUsuarioDTO.add(lDetalles);
					
					for (ParametrosModelDTO iterador: lGastosModelParametrosDTO) {
						
						BigDecimal lCalculoPuntual = new BigDecimal(0);						
						BalanceUsuarioModelDTO lCalculado = new BalanceUsuarioModelDTO();
						
						lCalculoPuntual = lGastosModelUsuarioDTO.get(0).getSalario().multiply(iterador.getValor()).divide(GastosModelUtil.UtilitiesGeneral.VALOR_CIEN);
						
						lCalculado.setDescripcion(iterador.getDescripcion());
						lCalculado.setValorCalculado(lCalculoPuntual);
						
						lCalculoTotal = lCalculoTotal.add(lCalculoPuntual);
						
						lGastosModelBalanceUsuarioDTO.add(lCalculado);
					}
					
					
					lDetalles = new BalanceUsuarioModelDTO();
					lDetalles.setDescripcion(GastosModelUtil.UtilitiesGeneral.TOTAL_DEDUCCIONES);
					lDetalles.setValorCalculado(lCalculoTotal);
					lGastosModelBalanceUsuarioDTO.add(lDetalles);
					
					lDetalles = new BalanceUsuarioModelDTO();
					lDetalles.setDescripcion(GastosModelUtil.UtilitiesGeneral.NETO_MENSUAL);
					lDetalles.setValorCalculado(lGastosModelUsuarioDTO.get(0).getSalario().subtract(lCalculoTotal));
					lGastosModelBalanceUsuarioDTO.add(lDetalles);
					
					lGastosModelDTO = (ArrayList<GastosModelDTO>) lGastosModelManagerImpl.consultarRegistros(GastosModelUtil.UtilitiesEfectivo.VALOR_TODOS, 
							GastosModelUtil.UtilitiesQuincenal.QUINCENA_TODAS, 
							pUsuario);
					
					if(lGastosModelDTO.size() > 0) {
						
						lTamanioArreglo = lGastosModelDTO.size();
						
						lDetalles = new BalanceUsuarioModelDTO();
						lDetalles.setDescripcion(GastosModelUtil.UtilitiesGeneral.TOTAL_GASTOS);
						lDetalles.setValorCalculado(lGastosModelDTO.get(lTamanioArreglo-1).getValor());
						lGastosModelBalanceUsuarioDTO.add(lDetalles);
						
						lDetalles = new BalanceUsuarioModelDTO();
						lDetalles.setDescripcion(GastosModelUtil.UtilitiesGeneral.SALDO_MENSUAL);
						lDetalles.setValorCalculado(lGastosModelUsuarioDTO.get(0).getSalario().subtract(lCalculoTotal).
								subtract(lGastosModelDTO.get(lTamanioArreglo- 1 ).getValor()));
						lGastosModelBalanceUsuarioDTO.add(lDetalles);
						
					} else {
						
						lDetalles = new BalanceUsuarioModelDTO();
						lDetalles.setDescripcion(GastosModelUtil.UtilitiesGeneral.SALDO_MENSUAL);
						lDetalles.setValorCalculado(GastosModelUtil.UtilitiesGeneral.VALOR_CERO);
						lGastosModelBalanceUsuarioDTO.add(lDetalles);
						
					}
				
				}
				
			}
			
		} catch (Exception ex) {
			
			lLoggerFacade.insertarError(this.getClass().getName(), GastosModelUtil.UtilitiesGeneral.ERROR_CONSULTA_GENERICO, ex);
			
		}
		
		lGastosModelBalanceUsuarioDTO= adicionSignoPesos(lGastosModelBalanceUsuarioDTO);
		
		return lGastosModelBalanceUsuarioDTO;
	}
	
	
	private ArrayList<BalanceUsuarioModelDTO> adicionSignoPesos(ArrayList<BalanceUsuarioModelDTO> pGastosModelDTO) {
		
		ArrayList<BalanceUsuarioModelDTO> lBalanceUsuarioModelDTO = new ArrayList<BalanceUsuarioModelDTO>();
		
		for (BalanceUsuarioModelDTO lBalanceUsuarioModelDTOVO : pGastosModelDTO) {
			
			String valorConvertido = lConversorPesos.valorConvertido(lBalanceUsuarioModelDTOVO.getValorCalculado());
			lBalanceUsuarioModelDTOVO.setValorToString(valorConvertido);
			
			lBalanceUsuarioModelDTO.add(lBalanceUsuarioModelDTOVO);
			
		}		
		
		return lBalanceUsuarioModelDTO;
	}

}
