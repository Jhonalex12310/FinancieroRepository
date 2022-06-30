package co.com.negocio.financiero.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class BalanceUsuarioModelDTO implements Serializable {
	
	private final static long serialVersionUID = 1L;
	
	private String descripcion;
	private BigDecimal valorCalculado;
	private String valorToString;
	
	public BalanceUsuarioModelDTO() {
		
	}
	
	public BalanceUsuarioModelDTO(String descripcion, BigDecimal valorCalculado,String valorToString) {
		super();
		this.descripcion = descripcion;
		this.valorCalculado = valorCalculado;
		this.valorToString = valorToString;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getValorCalculado() {
		return valorCalculado;
	}
	public void setValorCalculado(BigDecimal valorCalculado) {
		this.valorCalculado = valorCalculado;
	}
	
	
	public String getValorToString() {
		return valorToString;
	}

	public void setValorToString(String valorToString) {
		this.valorToString = valorToString;
	}

	public String toString() {
		
		return this.descripcion + " - " + this.valorCalculado.toString() + " - " + this.valorToString;
		
	}
	
	public Object clone() {
		
		return this.clone();
		
	}
}
