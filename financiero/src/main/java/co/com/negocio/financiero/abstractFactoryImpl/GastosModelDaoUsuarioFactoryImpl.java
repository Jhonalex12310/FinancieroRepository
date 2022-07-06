package co.com.negocio.financiero.abstractFactoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.com.negocio.financiero.abstractFactory.DAOAbstractFactory;
import co.com.negocio.financiero.daoFactory.GastosModelDao;
import co.com.negocio.financiero.daoFactory.daoFactoryImpl.GastosModelDaoUsuarioImpl;

@Component("GastosModelDaoUsuarioFactoryImpl")
public class GastosModelDaoUsuarioFactoryImpl extends DAOAbstractFactory {	

	@Autowired
	@Qualifier(value="GastosModelDaoUsuarioImpl")
	private GastosModelDaoUsuarioImpl lGastosModelDaoUsuarioImpl;	
	
	
	@Override
	public GastosModelDao ObtenerDao() {
		
		return lGastosModelDaoUsuarioImpl;
	}

}
