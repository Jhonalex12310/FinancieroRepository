package co.com.negocio.financiero.manager.managerImpl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import co.com.negocio.financiero.abstractFactory.DAOAbstractFactory;
import co.com.negocio.financiero.manager.GastosModelManagerInt;
import co.com.negocio.financiero.model.dto.UsuariosModelDTO;

@Service
@Transactional
@Component("GastosModelManagerUsuariosImpl")
public class GastosModelManagerUsuariosImpl implements GastosModelManagerInt {
	
	@Autowired
	@Qualifier("GastosModelDaoUsuarioFactoryImpl")
	private DAOAbstractFactory lDAOAbstractFactory;

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<UsuariosModelDTO> consultarRegistros(String pEfectivo, 
			String pQuincena, 
			    String pUsuario) throws Exception {
		
		ArrayList<UsuariosModelDTO> lRetorno = new ArrayList<UsuariosModelDTO>();
		
		lRetorno = (ArrayList<UsuariosModelDTO>) lDAOAbstractFactory.ObtenerDao().obtenerTotalRegistros(pUsuario);
		
		
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
