package co.com.negocio.financiero.facade.facadeImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.com.negocio.financiero.facade.ObservadorEventosFacadeInt;

@Service
public class ObservadorEventosFacadeLoggerImpl implements ObservadorEventosFacadeInt{	 
		
	static Logger logger = null;

	@Override
	public void InsertarMensajeConsole(String pClass, 
			String pMensaje, 
			Exception pException) throws ClassNotFoundException {
		
		@SuppressWarnings("rawtypes")
		Class classTemp = Class.forName(pClass);
		logger = LoggerFactory.getLogger(classTemp);
		logger.info(pMensaje, pException);
		
	}

	@Override
	public void InsertarErrorConsole(String pClass, 
			String pMensaje, 
			Exception pException) throws ClassNotFoundException {
		
		@SuppressWarnings("rawtypes")
		Class classTemp = Class.forName(pClass);
		logger = LoggerFactory.getLogger(classTemp);
		logger.error(pMensaje, pException);
		
	}

	@Override
	public void InsertarAdvertenciaConsole(String pClass, 
			String pMensaje, 
			Exception pException) throws ClassNotFoundException {
		
		@SuppressWarnings("rawtypes")
		Class classTemp = Class.forName(pClass);
		logger = LoggerFactory.getLogger(classTemp);
		logger.debug(pMensaje, pException);
		
	}
	
}
