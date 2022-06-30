package co.com.negocio.financiero.abstractFactory;

import co.com.negocio.financiero.daoFactory.GastosModelDao;

public abstract class DAOAbstractFactory {
	
	public abstract GastosModelDao getGastosModelDao();
	
	public abstract GastosModelDao getGastosModelDaoUsuario();
	
	public abstract GastosModelDao getGastosModelDaoParametrosImpl(); 
	
}
