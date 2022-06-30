package co.com.negocio.financiero.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggerFacade {	 
		
	static Logger logger = null;
	
	public void insertarError(String pClass, 
			String pMensaje, 
			Exception pException) throws ClassNotFoundException, InstantiationException, IllegalAccessException {			
		
		@SuppressWarnings("rawtypes")
		Class classTemp = Class.forName(pClass);
		logger = LoggerFactory.getLogger(classTemp);
		logger.error(pMensaje, pException);
		
	}
	
}
