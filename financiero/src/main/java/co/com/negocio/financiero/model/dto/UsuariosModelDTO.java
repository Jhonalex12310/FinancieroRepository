package co.com.negocio.financiero.model.dto;


import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosModelDTO {
	
	
	private BigDecimal idUsuario;
	
	private String estadoUsuario;
	
	private String nombreUsuario;
	
	private BigDecimal conteo;
	
	private BigDecimal salario;
	
	private Date fecha;
	
	
}
