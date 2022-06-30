package co.com.negocio.financiero.daoFactory.daoFactoryImpl;

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

import co.com.negocio.financiero.daoFactory.GastosModelDao;
import co.com.negocio.financiero.facade.LoggerFacade;
import co.com.negocio.financiero.model.dto.ParametrosModelDTO;
import co.com.negocio.financiero.model.entity.ParametrosEntity;
import co.com.negocio.financiero.utilidades.GastosModelUtil;

@Repository
@Transactional
@Component("GastosModelDaoParametrosImpl")
public class GastosModelDaoParametrosImpl implements GastosModelDao {

	@Autowired
	private LoggerFacade lLoggerFacade;
	
	@PersistenceContext
	private EntityManager lEntityManager;
	
	private ModelMapper lModelMapper = new ModelMapper();
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<ParametrosModelDTO> obtenerTotalRegistros(String pUsuario) throws Exception {
		
		ArrayList<ParametrosModelDTO> lParametrosModelDTO = new ArrayList<ParametrosModelDTO>();		
		List<ParametrosEntity> lParametrosEntity = new ArrayList<ParametrosEntity>();
		Query lQuery = lEntityManager.createNamedQuery("ParametrosEntity.findById");
		lQuery.setParameter("tipo",pUsuario);
		
		try {
		
			lParametrosEntity= lQuery.getResultList();
			
			if (lParametrosEntity.size() > 0 ) {
				
				for( ParametrosEntity vo: lParametrosEntity) {
					
					ParametrosModelDTO lParametrosModelDTOAux = new ParametrosModelDTO();
					lParametrosModelDTOAux = lModelMapper.map(vo, ParametrosModelDTO.class);
					lParametrosModelDTO.add(lParametrosModelDTOAux);
					
				}
				
			}
			
		} catch (Exception ex) {
			
			lLoggerFacade.insertarError(this.getClass().getName(), GastosModelUtil.UtilitiesGeneral.ERROR_CONSULTA_BASE_DATOS, ex);
			
		}
		
		return lParametrosModelDTO;
	}

	@Override
	public boolean ActualizarRegisto(Object pObjetoEntrada) throws Exception {
		
		boolean lRetorno = true;		
		ParametrosEntity lParametrosEntity = new ParametrosEntity();
		ParametrosModelDTO lGastosModelParametrosDTO= new ParametrosModelDTO();
		
		try {			
		
			lGastosModelParametrosDTO= (ParametrosModelDTO) pObjetoEntrada;
			lParametrosEntity = lModelMapper.map(lGastosModelParametrosDTO, ParametrosEntity.class);
			lEntityManager.merge(lParametrosEntity);
		
		} catch (Exception ex) {
			
			lRetorno = false ;
			lLoggerFacade.insertarError(this.getClass().getName(), GastosModelUtil.UtilitiesGeneral.ERROR_ACTUALIZACION_BASE_DATOS, ex);
			
		}  
		
		return lRetorno;
	}

	@Override
	public boolean InsertarRegisto(Object pObjetoEntrada) throws Exception {
		
		boolean lRetorno = true;			
		ParametrosEntity lParametrosEntity = new ParametrosEntity();
		ParametrosModelDTO lGastosModelParametrosDTO= new ParametrosModelDTO();
		
		try { 
			
			lGastosModelParametrosDTO= (ParametrosModelDTO) pObjetoEntrada;
			lParametrosEntity = lModelMapper.map(lGastosModelParametrosDTO, ParametrosEntity.class);
			lEntityManager.persist(lParametrosEntity);
		
		} catch (Exception ex) {
			
			lRetorno = false;
			lLoggerFacade.insertarError(this.getClass().getName(), GastosModelUtil.UtilitiesGeneral.ERROR_INSERCION_BASE_DATOS, ex);
			
		}  
		
		return lRetorno;
	}

	@Override
	public boolean EliminarRegisto(Object pObjetoEntrada) throws Exception {
		
		boolean lRetorno = true;			
		ParametrosEntity lParametrosEntity = new ParametrosEntity();
		ParametrosModelDTO lGastosModelParametrosDTO= new ParametrosModelDTO();
		
		try { 
			
			lGastosModelParametrosDTO= (ParametrosModelDTO) pObjetoEntrada;
			lParametrosEntity = lModelMapper.map(lGastosModelParametrosDTO, ParametrosEntity.class);
			lEntityManager.remove(lEntityManager.merge(lParametrosEntity));
			
		} catch (Exception ex) {
			
			lRetorno = false;
			lLoggerFacade.insertarError(this.getClass().getName(), GastosModelUtil.UtilitiesGeneral.ERROR_BORRADO_BASE_DATOS, ex);
			
		}  
		
		return lRetorno;
	}

}
