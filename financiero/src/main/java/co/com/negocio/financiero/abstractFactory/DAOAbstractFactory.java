package co.com.negocio.financiero.abstractFactory;

import co.com.negocio.financiero.daoFactory.GastosModelDaoInt;

public abstract class DAOAbstractFactory {
	
	public abstract GastosModelDaoInt ObtenerDao();
	
}
