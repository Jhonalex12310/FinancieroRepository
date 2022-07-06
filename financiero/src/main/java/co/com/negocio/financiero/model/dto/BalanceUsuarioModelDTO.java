package co.com.negocio.financiero.model.dto;

import java.math.BigDecimal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceUsuarioModelDTO {	
		
	private String descripcion;
	
	private BigDecimal valorCalculado;
	
	private String valorToString;
	
}
