package co.com.negocio.financiero.manager;

import java.util.ArrayList;

public interface GastosModelManagerInt {
	
	ArrayList<?> consultarRegistros(String pEfectivo, 
			String pQuincena, 
			   String pUsuario) throws Exception;
	
	boolean ActualizarRegisto(Object pObjetoEntrada) throws Exception;
	
	boolean InsertarRegisto(Object pObjetoEntrada) throws Exception;
	
	boolean EliminarRegisto(Object pObjetoEntrada) throws Exception;
}
