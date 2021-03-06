package co.com.negocio.financiero.manager.managerImpl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import co.com.negocio.financiero.abstractFactory.DAOAbstractFactory;
import co.com.negocio.financiero.manager.GastosModelManager;
import co.com.negocio.financiero.model.dto.ParametrosModelDTO;

@Service
@Transactional
@Component("GastosModelManagerParametrosImpl")
public class GastosModelManagerParametrosImpl implements GastosModelManager {
	
	@Autowired
	private DAOAbstractFactory lDAOAbstractFactory;
		
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<ParametrosModelDTO> consultarRegistros(String pEfectivo, 
			String pQuincena, 
			    String pUsuario) throws Exception {
		
		ArrayList<ParametrosModelDTO> lRetorno = new ArrayList<ParametrosModelDTO>();
		
		lRetorno = (ArrayList<ParametrosModelDTO>) lDAOAbstractFactory.getGastosModelDaoParametrosImpl().obtenerTotalRegistros(pUsuario);
		
		
		return lRetorno;
	}
	
	
	@Override
	public boolean ActualizarRegisto(Object pObjetoEntrada) throws Exception {

		boolean lRetorno = false;
		
		lRetorno = lDAOAbstractFactory.getGastosModelDaoParametrosImpl().ActualizarRegisto(pObjetoEntrada);
		
		return lRetorno;
	}

	@Override
	public boolean InsertarRegisto(Object pObjetoEntrada) throws Exception {

		boolean lRetorno = false;
		
		lRetorno = lDAOAbstractFactory.getGastosModelDaoParametrosImpl().InsertarRegisto(pObjetoEntrada);
		
		return lRetorno;
	}

	@Override
	public boolean EliminarRegisto(Object pObjetoEntrada) throws Exception {

		boolean lRetorno = false;
		
		lRetorno = lDAOAbstractFactory.getGastosModelDaoParametrosImpl().EliminarRegisto(pObjetoEntrada);
		
		return lRetorno;
	}


}
