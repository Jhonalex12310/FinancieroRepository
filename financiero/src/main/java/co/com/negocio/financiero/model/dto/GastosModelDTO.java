package co.com.negocio.financiero.model.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GastosModelDTO {
	
	private BigDecimal idGastos;
	
	private String descripcion;
	
	private BigDecimal valor;
	
	private String quincenaUno;
	
	private String quincenaDos;
	
	private String efectivo;
	
	private String usuario;
	
	private String valorToString;
	

}
