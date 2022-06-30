package co.com.negocio.financiero.utilidades;

import java.math.BigDecimal;

public class GastosModelUtil {
	
	public static final class UtilitiesEfectivo {
		
		public static final String VALOR_AFIRMATIVO = "A";
		public static final String VALOR_NEGATIVO = "N";
		public static final String VALOR_TODOS = "T";
		
	}

	public static final class UtilitiesQuincenal {
		
		public static final String QUINCENA_1 = "1";
		public static final String QUINCENA_2 = "2";
		public static final String QUINCENA_TODAS = "T";
		public static final String VALOR_AFIRMATIVO = "A";
		public static final String VALOR_NEGATIVO = "N";
		
	}
	
	public static final class UtilitiesGeneral {
		
		public static final String TOTAL_GENERAL = "TOTAL";
		public static final String TOTAL_GASTOS = "TOTAL GASTOS";
		public static final String TOTAL_DEDUCCIONES = "TOTAL DEDUCCIONES";
		public static final String CONCEPTO_SALARIO = "SALARIO";
		public static final BigDecimal VALOR_CERO = new BigDecimal(0);
		public static final BigDecimal VALOR_CIEN = new BigDecimal(100);
		public static final String NETO_MENSUAL = "NETO_MENSUAL";
		public static final String SALDO_MENSUAL = "SALDO_MENSUAL";
		public static final String ERROR_CONEXION_BASE_DATOS ="Se ha presentado un error al obtener la conexion: ";
		public static final String ERROR_CIERRE_CONEXION ="Se ha presentado un error al cerrar la conexion: ";
		public static final String ERROR_CONSULTA_BASE_DATOS ="Se ha presentado un error al consultar: ";
		public static final String ERROR_ACTUALIZACION_BASE_DATOS ="Se ha presentado un error al actualizar: ";
		public static final String ERROR_BORRADO_BASE_DATOS ="Se ha presentado un error al borrar: ";
		public static final String ERROR_INSERCION_BASE_DATOS ="Se ha presentado un error al insertar: ";
		public static final String ERROR_CONSULTA_GENERICO ="Se ha presentado un error al realizar la consulta  ";
		public static final String ERROR_ARCHIVO_PROPIEDADES = "Archivo de propiedades ? no encontrado en el classpath";
		public static final String MENSAJE_SIN_REGISTROS = "No existen registros disponibles";
		public static final String ERROR_CONVERSION = "Se presento el siguiente error al realizar la conversion: ";
				
	}
	
	public static final class Properties {
		
		public static final String PROPIEDAD_USUARIO = "username";
		public static final String PROPIEDAD_CLAVE = "password";
		public static final String PROPIEDAD_CONECTOR = "connector";
		public static final String PROPIEDAD_DRIVER = "driver";
		public static final String PROPIEDAD_ESQUEMA = "dbname";
		public static final String ARCHIVO_PROPIEDADES = "application.properties";
		
	}
	
	public static final class SQLGastosQueryProperties {
		
		public static final String ARCHIVO_PROPIEDADES = "SQLGastos.properties";
		public static final String QUERY_FIND_ALL = "find_all";
		public static final String QUERY_UPDATE = "update";
		public static final String QUERY_DELETE = "delete";
		public static final String QUERY_INSERT = "insert";
		
	}
	
	public static final class SQLUsuariossQueryProperties {
		
		public static final String ARCHIVO_PROPIEDADES = "SQLUsuarios.properties";
		public static final String QUERY_FIND_ALL = "find_all";
		public static final String QUERY_UPDATE = "update";
		public static final String QUERY_DELETE = "delete";
		public static final String QUERY_INSERT = "insert";
		
	}
	
public static final class SQLParametrosQueryProperties {
		
		public static final String ARCHIVO_PROPIEDADES = "SQLParametros.properties";
		public static final String QUERY_FIND_ALL = "find_all";
		public static final String QUERY_UPDATE = "update";
		public static final String QUERY_DELETE = "delete";
		public static final String QUERY_INSERT = "insert";
		
	}
}
