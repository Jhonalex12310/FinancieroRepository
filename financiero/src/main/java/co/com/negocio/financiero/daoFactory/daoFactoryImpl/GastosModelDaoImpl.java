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
import co.com.negocio.financiero.model.dto.GastosModelDTO;
import co.com.negocio.financiero.model.entity.GastosEntity;
import co.com.negocio.financiero.utilidades.GastosModelUtil;

@Repository
@Transactional
@Component("GastosModelDaoImpl")
public class GastosModelDaoImpl implements GastosModelDaoInt {
	
	@Autowired
	private ObservadorEventosFacadeInt lLoggerFacade;
	
	@PersistenceContext
	private EntityManager lEntityManager;
	
	private ModelMapper lModelMapper = new ModelMapper();

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<GastosModelDTO> obtenerTotalRegistros(String pUsuario) throws Exception {
		
		ArrayList<GastosModelDTO> lGastosModelDTO = new ArrayList<GastosModelDTO>();		
		List<GastosEntity> lGastosEntity = new ArrayList<GastosEntity>();
		Query lQuery = lEntityManager.createNamedQuery("GastosEntity.findById");
		lQuery.setParameter("tipo", new BigDecimal(pUsuario) );
		
		try {
		
			lGastosEntity = lQuery.getResultList();
			
			if( lGastosEntity.size() > 0) {
				
				for(GastosEntity vo: lGastosEntity) {
					
					GastosModelDTO lGastosModelDTOAux = new GastosModelDTO();
					lGastosModelDTOAux = lModelMapper.map(vo, GastosModelDTO.class);
					lGastosModelDTO.add(lGastosModelDTOAux);
					
				}
				
			}
			
		} catch (Exception ex) {
			
			lLoggerFacade.InsertarErrorConsole(this.getClass().getName(), GastosModelUtil.UtilitiesGeneral.ERROR_CONSULTA_BASE_DATOS, ex);
			
		} 		
		return lGastosModelDTO;
	}

	@Override
	public boolean ActualizarRegisto(Object pObjetoEntrada) throws Exception {		
		
		boolean lRetorno = true;		
		GastosEntity lGastosEntity = new GastosEntity();
		GastosModelDTO lGastosModelDTO= new GastosModelDTO();
		
		try { 
			
			lGastosModelDTO = (GastosModelDTO) pObjetoEntrada;
			lGastosEntity = lModelMapper.map(lGastosModelDTO, GastosEntity.class);
			lEntityManager.merge(lGastosEntity);
		
		} catch (Exception ex) {
			
			lRetorno = false ;
			lLoggerFacade.InsertarErrorConsole(this.getClass().getName(), GastosModelUtil.UtilitiesGeneral.ERROR_ACTUALIZACION_BASE_DATOS, ex);
		
		}  
		
		return lRetorno;
	}

	@Override
	public boolean InsertarRegisto(Object pObjetoEntrada) throws Exception {
		
		boolean lRetorno = true;			
		GastosEntity lGastosEntity = new GastosEntity();
		GastosModelDTO lGastosModelDTO= new GastosModelDTO();
		
		try  { 			
		
			lGastosModelDTO = (GastosModelDTO) pObjetoEntrada;
			lGastosEntity = lModelMapper.map(lGastosModelDTO, GastosEntity.class);
			lEntityManager.persist(lGastosEntity);
			
		} catch (Exception ex) {
			
			lRetorno = false;
			lLoggerFacade.InsertarErrorConsole(this.getClass().getName(), GastosModelUtil.UtilitiesGeneral.ERROR_INSERCION_BASE_DATOS, ex);
		
		}  
		
		return lRetorno;
	}

	@Override
	public boolean EliminarRegisto(Object pObjetoEntrada) throws Exception {		
		
		boolean lRetorno = true;			
		GastosEntity lGastosEntity = new GastosEntity();
		GastosModelDTO lGastosModelDTO= new GastosModelDTO();
		
		try { 
			
			lGastosModelDTO = (GastosModelDTO) pObjetoEntrada;
			lGastosEntity = lModelMapper.map(lGastosModelDTO, GastosEntity.class);
			lEntityManager.remove(lEntityManager.merge(lGastosEntity));
			
		} catch (Exception ex) {
			
			lRetorno = false;
			lLoggerFacade.InsertarErrorConsole(this.getClass().getName(), GastosModelUtil.UtilitiesGeneral.ERROR_BORRADO_BASE_DATOS, ex);
		
		}  
		return lRetorno;
	}

}
