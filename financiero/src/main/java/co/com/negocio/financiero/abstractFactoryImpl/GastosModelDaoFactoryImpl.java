package co.com.negocio.financiero.abstractFactoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.com.negocio.financiero.abstractFactory.DAOAbstractFactory;
import co.com.negocio.financiero.daoFactory.GastosModelDaoInt;

@Component("GastosModelDaoFactoryImpl")
public class GastosModelDaoFactoryImpl extends DAOAbstractFactory {
	
	@Autowired
	@Qualifier(value="GastosModelDaoImpl")
	private GastosModelDaoInt lGastosModelDaoImpl;		
	
	@Override
	public GastosModelDaoInt ObtenerDao() {
		
		return lGastosModelDaoImpl;
		
	}

}
