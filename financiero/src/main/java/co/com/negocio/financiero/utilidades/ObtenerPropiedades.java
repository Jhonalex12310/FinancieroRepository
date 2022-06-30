package co.com.negocio.financiero.utilidades;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ObtenerPropiedades {
	
	
	public Properties getPropiedades(String pArchivoPropiedades) throws Exception{
		
		Properties lProperties = new Properties();
		
		try  {
			
			  ClassLoader classLoader = getClass().getClassLoader();
			  InputStream lInputStream = classLoader.getResourceAsStream(pArchivoPropiedades);
			 	
			  lProperties.load(lInputStream);
			  
			  
		} catch(FileNotFoundException e) {
			
			throw new Exception(GastosModelUtil.UtilitiesGeneral.ERROR_ARCHIVO_PROPIEDADES.
					replace("?", pArchivoPropiedades));
			
		} catch(Exception e) {
			
			throw new Exception(GastosModelUtil.UtilitiesGeneral.ERROR_CONSULTA_GENERICO);
			
		}
		
		return lProperties;
	}
}
