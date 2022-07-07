package co.com.negocio.financiero.facade;

public interface ObservadorEventosFacadeInt {
	
	public void InsertarMensajeConsole(String pClass, 
			String pMensaje, 
			Exception pException) throws ClassNotFoundException;
	
	public void InsertarErrorConsole(String pClass, 
			String pMensaje, 
			Exception pException) throws ClassNotFoundException;
	
	public void InsertarAdvertenciaConsole(String pClass, 
			String pMensaje, 
			Exception pException) throws ClassNotFoundException;

}
