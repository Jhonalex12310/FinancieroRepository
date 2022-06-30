package co.com.negocio.financiero.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.OK,reason ="This customer is not found in the system")
public class DataNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 100L;

}
