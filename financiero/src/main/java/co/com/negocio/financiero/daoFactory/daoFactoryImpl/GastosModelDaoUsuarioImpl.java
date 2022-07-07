package co.com.negocio.financiero.daoFactory.daoFactoryImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import co.com.negocio.financiero.daoFactory.GastosModelDaoInt;
import co.com.negocio.financiero.facade.ObservadorEventosFacadeInt;
import co.com.negocio.financiero.model.dto.UsuariosModelDTO;
import co.com.negocio.financiero.model.entity.UsuariosEntity;
import co.com.negocio.financiero.utilidades.GastosModelUtil;

@Repository
@Transactional
@Component("GastosModelDaoUsuarioImpl")
public class GastosModelDaoUsuarioImpl implements GastosModelDaoInt {

	@Autowired
	private ObservadorEventosFacadeInt lLoggerFacade;
	
	@PersistenceContext
	private EntityManager lEntityManager;
	
	private ModelMapper lModelMapper = new ModelMapper();
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<UsuariosModelDTO> obtenerTotalRegistros(String pUsuario) throws Exception {
		
		ArrayList<UsuariosModelDTO> lGastosModelUsuarioDTO = new ArrayList<UsuariosModelDTO>();			
		List<UsuariosEntity> lUsuariosEntity = new ArrayList<UsuariosEntity>();
		Query lQuery = lEntityManager.createNamedQuery("UsuariosEntity.findById");
		lQuery.setParameter("tipo", new BigDecimal(pUsuario) );
		
		try {
		
			lUsuariosEntity = lQuery.getResultList();
			
			if( lUsuariosEntity.size() > 0 ) {
				
				for(UsuariosEntity vo : lUsuariosEntity) {
					
					UsuariosModelDTO lGastosModelUsuarioDTOAux= new UsuariosModelDTO();
					lGastosModelUsuarioDTOAux = lModelMapper.map(vo, UsuariosModelDTO.class);
					lGastosModelUsuarioDTO.add(lGastosModelUsuarioDTOAux);
				
				}
				
			}			
			
		} catch (Exception ex) {
			
			lLoggerFacade.InsertarErrorConsole(this.getClass().getName(), GastosModelUtil.UtilitiesGeneral.ERROR_CONSULTA_BASE_DATOS, ex);
			
		} 
		
		return lGastosModelUsuarioDTO;
	}

	@Override
	public boolean ActualizarRegisto(Object pObjetoEntrada) throws Exception {
		
		boolean lRetorno = true;		
		UsuariosEntity lUsuariosEntity = new UsuariosEntity();
		UsuariosModelDTO lGastosModelUsuarioDTO= new UsuariosModelDTO();
		
		try {			
		
			lGastosModelUsuarioDTO= (UsuariosModelDTO) pObjetoEntrada;
			lUsuariosEntity = lModelMapper.map(lGastosModelUsuarioDTO, UsuariosEntity.class);
			lEntityManager.merge(lUsuariosEntity);
				
		} catch (Exception ex) {
			
			lRetorno = false ;
			lLoggerFacade.InsertarErrorConsole(this.getClass().getName(), GastosModelUtil.UtilitiesGeneral.ERROR_ACTUALIZACION_BASE_DATOS, ex);
		
		}  
		
		return lRetorno;
	}

	@Override
	public boolean InsertarRegisto(Object pObjetoEntrada) throws Exception {
		
		boolean lRetorno = true;		
		UsuariosEntity lUsuariosEntity = new UsuariosEntity();
		UsuariosModelDTO lGastosModelUsuarioDTO= new UsuariosModelDTO();
		
		try {			
		
			lGastosModelUsuarioDTO= (UsuariosModelDTO) pObjetoEntrada;
			lUsuariosEntity = lModelMapper.map(lGastosModelUsuarioDTO, UsuariosEntity.class);
			lEntityManager.persist(lUsuariosEntity);
				
		} catch (Exception ex) {
			
			lRetorno = false ;
			lLoggerFacade.InsertarErrorConsole(this.getClass().getName(), GastosModelUtil.UtilitiesGeneral.ERROR_INSERCION_BASE_DATOS, ex);
		
		}  
			
		return lRetorno;
	}

	@Override
	public boolean EliminarRegisto(Object pObjetoEntrada) throws Exception {
		
		boolean lRetorno = true;		
		UsuariosEntity lUsuariosEntity = new UsuariosEntity();
		UsuariosModelDTO lGastosModelUsuarioDTO= new UsuariosModelDTO();
		
		try {			
		
			lGastosModelUsuarioDTO= (UsuariosModelDTO) pObjetoEntrada;
			lUsuariosEntity = lModelMapper.map(lGastosModelUsuarioDTO, UsuariosEntity.class);
			lEntityManager.remove(lEntityManager.merge(lUsuariosEntity));
				
		} catch (Exception ex) {
			
			lRetorno = false ;
			lLoggerFacade.InsertarErrorConsole(this.getClass().getName(), GastosModelUtil.UtilitiesGeneral.ERROR_BORRADO_BASE_DATOS, ex);
		
		} 
		
		return lRetorno;
	}

}
