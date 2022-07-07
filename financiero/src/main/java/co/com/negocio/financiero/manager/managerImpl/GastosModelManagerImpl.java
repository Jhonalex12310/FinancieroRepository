package co.com.negocio.financiero.manager.managerImpl;

import java.util.ArrayList;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import co.com.negocio.financiero.abstractFactory.DAOAbstractFactory;
import co.com.negocio.financiero.manager.GastosModelManagerInt;
import co.com.negocio.financiero.model.dto.GastosModelDTO;
import co.com.negocio.financiero.utilidades.ConversorPesos;
import co.com.negocio.financiero.utilidades.GastosModelUtil;

@Service
@Transactional
@Component("GastosModelManagerImpl")
public class GastosModelManagerImpl implements GastosModelManagerInt {
	
	@Autowired	
	@Qualifier("GastosModelDaoFactoryImpl")
	private DAOAbstractFactory lDAOAbstractFactory;
	
	@Autowired	
	private ConversorPesos lConversorPesos;
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<GastosModelDTO> consultarRegistros(String pEfectivo, 
			String pQuincena, 
			    String pUsuario) throws Exception {
		
		ArrayList<GastosModelDTO> lGastosModelDTO = new ArrayList<GastosModelDTO>();
		ArrayList<GastosModelDTO> lRetorno = new ArrayList<GastosModelDTO>();
		
		lGastosModelDTO = (ArrayList<GastosModelDTO>) lDAOAbstractFactory.ObtenerDao().obtenerTotalRegistros(pUsuario);		

		
		if(lGastosModelDTO.size() > 0) {
			
			lRetorno = configuracionEfectivo(lGastosModelDTO, pEfectivo.toUpperCase());
			lRetorno = configuracionQuincenas (lRetorno,pQuincena.toUpperCase());
			
			if(lRetorno.size()>0) {
			
				lRetorno = obtenerSumatoria(lRetorno);
				lRetorno = adicionSignoPesos(lRetorno);
				
			}
		}
		
		return lRetorno;
	}
	
	private ArrayList<GastosModelDTO> obtenerSumatoria(ArrayList<GastosModelDTO> pGastosModelDTO){
		
		GastosModelDTO lRetorno = new GastosModelDTO();
		lRetorno.setDescripcion(GastosModelUtil.UtilitiesGeneral.TOTAL_GENERAL);
		lRetorno.setValor(GastosModelUtil.UtilitiesGeneral.VALOR_CERO);
		
		for(GastosModelDTO lGastosModelDTO: pGastosModelDTO) {
		
			lRetorno.setValor(lRetorno.getValor().add(lGastosModelDTO.getValor()));
			
		}
		
		pGastosModelDTO.add(lRetorno);
		
		return pGastosModelDTO;
	}
	
	private ArrayList<GastosModelDTO> adicionSignoPesos(ArrayList<GastosModelDTO> pGastosModelDTO) {
		
		ArrayList<GastosModelDTO> lGastosModelDTORetorno = new ArrayList<GastosModelDTO>();
		
		for (GastosModelDTO lGastosModelDTO : pGastosModelDTO) {
			
			String valorConvertido = lConversorPesos.valorConvertido(lGastosModelDTO.getValor());
			lGastosModelDTO.setValorToString(valorConvertido);
			
			lGastosModelDTORetorno.add(lGastosModelDTO);
			
		}
		
		
		return lGastosModelDTORetorno;
	}
	
	private ArrayList<GastosModelDTO> configuracionEfectivo(ArrayList<GastosModelDTO> pGastosModelDTO,
			String pEfectivo) {
	
		ArrayList<GastosModelDTO> lRetorno = new ArrayList<GastosModelDTO>();
		
		switch (pEfectivo) {
		
		case GastosModelUtil.UtilitiesEfectivo.VALOR_AFIRMATIVO:
			
			for(GastosModelDTO lGastosModelDTO: pGastosModelDTO) {
				
				if(lGastosModelDTO.getEfectivo().contentEquals(GastosModelUtil.UtilitiesEfectivo.VALOR_AFIRMATIVO)) {
					
					lRetorno.add(lGastosModelDTO);
				}
			}
			
			break;

		case GastosModelUtil.UtilitiesEfectivo.VALOR_NEGATIVO:
			
			for(GastosModelDTO lGastosModelDTO: pGastosModelDTO) {
				
				if(lGastosModelDTO.getEfectivo().contentEquals(GastosModelUtil.UtilitiesEfectivo.VALOR_NEGATIVO)) {
					
					lRetorno.add(lGastosModelDTO);
				}
			}
			
			break;
			
		case GastosModelUtil.UtilitiesEfectivo.VALOR_TODOS:
			
			lRetorno = pGastosModelDTO;
				
			break;
		}
				
		return lRetorno;
		
	}
	
	private ArrayList<GastosModelDTO> configuracionQuincenas(ArrayList<GastosModelDTO> pGastosModelDTO,
			String pQuincena) {
	
		ArrayList<GastosModelDTO> lRetorno = new ArrayList<GastosModelDTO>();
		
		switch (pQuincena) {
		
		case GastosModelUtil.UtilitiesQuincenal.QUINCENA_1:
			
			for(GastosModelDTO lGastosModelDTO: pGastosModelDTO) {
				
				if(lGastosModelDTO.getQuincenaUno().contentEquals(GastosModelUtil.UtilitiesQuincenal.VALOR_AFIRMATIVO)) {
					
					lRetorno.add(lGastosModelDTO);
				}
			}
			
			break;

		case GastosModelUtil.UtilitiesQuincenal.QUINCENA_2:
			
			for(GastosModelDTO lGastosModelDTO: pGastosModelDTO) {
				
				if(lGastosModelDTO.getQuincenaDos().contentEquals(GastosModelUtil.UtilitiesQuincenal.VALOR_AFIRMATIVO)) {
					
					lRetorno.add(lGastosModelDTO);
				}
			}
			
			break;
			
		case GastosModelUtil.UtilitiesQuincenal.QUINCENA_TODAS:
			
			lRetorno = pGastosModelDTO;
				
			break;
		}
				
		return lRetorno;
		
	}

	@Override
	public boolean ActualizarRegisto(Object pObjetoEntrada) throws Exception {

		boolean lRetorno = false;
		
		lRetorno = lDAOAbstractFactory.ObtenerDao().ActualizarRegisto(pObjetoEntrada);
		
		return lRetorno;
	}

	@Override
	public boolean InsertarRegisto(Object pObjetoEntrada) throws Exception {

		boolean lRetorno = false;
		
		lRetorno = lDAOAbstractFactory.ObtenerDao().InsertarRegisto(pObjetoEntrada);
		
		return lRetorno;
	}

	@Override
	public boolean EliminarRegisto(Object pObjetoEntrada) throws Exception {

		boolean lRetorno = false;
		
		lRetorno = lDAOAbstractFactory.ObtenerDao().EliminarRegisto(pObjetoEntrada);
		
		return lRetorno;
	}

}
