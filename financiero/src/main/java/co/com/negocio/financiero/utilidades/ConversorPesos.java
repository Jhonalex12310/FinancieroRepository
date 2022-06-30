package co.com.negocio.financiero.utilidades;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.negocio.financiero.facade.LoggerFacade;

@Service
public class ConversorPesos {	
	
	private static final String SIGNO_PESOS = "$ ";
	
	@Autowired
	private LoggerFacade lLoggerFacade;
	
	
	public String valorConvertido(BigDecimal pValorEntrada) {
		
		String valorSalida = null;
		String lRetorno = null;
				
		try {
			
			valorSalida = pValorEntrada.toString();
			
			if(valorSalida.contains(".")) {
				
				String[] separacionDec = valorSalida.split("\\.");
				String valorEntero = separacionDec[0];
				String valorDecimal = separacionDec[1];
				
				lRetorno = adicionSignoPesos(valorEntero).concat(",").concat(valorDecimal.substring(0,1));
				
			} else {
				
				lRetorno = adicionSignoPesos(valorSalida);
				
			}
			
		} catch (Exception ex) {

			try {
				
				lLoggerFacade.insertarError(this.getClass().getName(), GastosModelUtil.UtilitiesGeneral.ERROR_CONVERSION, ex);
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
				
			} catch (InstantiationException e) {
				
				e.printStackTrace();
				
			} catch (IllegalAccessException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		return lRetorno;
		
	}
	
	private String adicionSignoPesos(String pValorIngresado) {
		
		String lRetorno = null;
		int tamanio = pValorIngresado.length();
		int lIterador = 3;
		int lContador = 0;
		
		for(int a = 1 ; a <= tamanio ; a++) {
						
			if(a == lIterador ) {
				
				 if(lContador == 0 ) {
					 
					lRetorno =  pValorIngresado.substring(tamanio-a, tamanio);
					lContador = tamanio - a;
					
				 }  else {
					 
					 lRetorno =  pValorIngresado.substring(lContador-3, lContador) + "." + lRetorno;
					 lContador= lContador - 3;
					 
				 }
				 
				lIterador= lIterador + 3 ;
				
			}		
			
		}
		
		if(lContador == 2) {
			 
			lRetorno =  pValorIngresado.substring(0, 2) + "." + lRetorno;
			 
		} else if (lContador == 1) {
			 
			lRetorno =  pValorIngresado.substring(0,1) + "." + lRetorno;
			 
		}
		
		return SIGNO_PESOS + lRetorno;
		
	}

}
