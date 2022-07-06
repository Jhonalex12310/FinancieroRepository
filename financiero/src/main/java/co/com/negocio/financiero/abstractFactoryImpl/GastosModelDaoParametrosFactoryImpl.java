package co.com.negocio.financiero.abstractFactoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.com.negocio.financiero.abstractFactory.DAOAbstractFactory;
import co.com.negocio.financiero.daoFactory.GastosModelDao;
import co.com.negocio.financiero.daoFactory.daoFactoryImpl.GastosModelDaoParametrosImpl;

@Component("GastosModelDaoParametrosFactoryImpl")
public class GastosModelDaoParametrosFactoryImpl extends DAOAbstractFactory {
	
	@Autowired
	@Qualifier(value="GastosModelDaoParametrosImpl")
	private GastosModelDaoParametrosImpl lGastosModelDaoParametrosImpl;
	
	@Override
	public GastosModelDao ObtenerDao() {
		
		return lGastosModelDaoParametrosImpl;
		
	}

}
