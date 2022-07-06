package co.com.negocio.financiero.model.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParametrosModelDTO  {	
	
	private BigDecimal idParametro;
	
	private String descripcion;
	
	private BigDecimal valor;
	
	private String idUsuario ;	
	

}
