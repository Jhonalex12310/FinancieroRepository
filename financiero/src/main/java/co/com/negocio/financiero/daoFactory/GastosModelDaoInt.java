package co.com.negocio.financiero.daoFactory;

import java.util.ArrayList;

public interface GastosModelDaoInt {
	
	ArrayList<?> obtenerTotalRegistros(String pUsuario) throws Exception;
	
	boolean ActualizarRegisto(Object pObjetoEntrada) throws Exception;
	
	boolean InsertarRegisto(Object pObjetoEntrada) throws Exception;
	
	boolean EliminarRegisto(Object pObjetoEntrada) throws Exception;
	
}
