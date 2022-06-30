package co.com.negocio.financiero.abstractFactoryImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.com.negocio.financiero.abstractFactory.DAOAbstractFactory;
import co.com.negocio.financiero.daoFactory.GastosModelDao;
import co.com.negocio.financiero.daoFactory.daoFactoryImpl.GastosModelDaoImpl;
import co.com.negocio.financiero.daoFactory.daoFactoryImpl.GastosModelDaoParametrosImpl;
import co.com.negocio.financiero.daoFactory.daoFactoryImpl.GastosModelDaoUsuarioImpl;

@Service
@Transactional
public class DAOAbstractFactoryImpl extends DAOAbstractFactory {

	@Autowired
	@Qualifier(value="GastosModelDaoImpl")
	private GastosModelDaoImpl lGastosModelDaoImpl;		
	
	@Autowired
	@Qualifier(value="GastosModelDaoUsuarioImpl")
	private GastosModelDaoUsuarioImpl lGastosModelDaoUsuarioImpl;	
	
	@Autowired
	@Qualifier(value="GastosModelDaoParametrosImpl")
	private GastosModelDaoParametrosImpl lGastosModelDaoParametrosImpl;
		
	@Override
	public GastosModelDao getGastosModelDao() {
		return lGastosModelDaoImpl;
	}

	@Override
	public GastosModelDao getGastosModelDaoUsuario() {		
		return lGastosModelDaoUsuarioImpl;
	}

	@Override
	public GastosModelDao getGastosModelDaoParametrosImpl() {
		return lGastosModelDaoParametrosImpl;
	}

}
