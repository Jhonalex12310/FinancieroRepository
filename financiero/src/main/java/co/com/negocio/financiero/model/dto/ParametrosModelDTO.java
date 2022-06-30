package co.com.negocio.financiero.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ParametrosModelDTO implements Serializable {
	
	private final static long serialVersionUID = 1L;
	
	private BigDecimal idParametro;
	private String descripcion;
	private BigDecimal valor;
	private String idUsuario ;
	
	public ParametrosModelDTO() {
		
	}
	
	public ParametrosModelDTO(BigDecimal idParametro, String descripcion, BigDecimal valor, String idUsuario) {
		super();
		this.idParametro = idParametro;
		this.descripcion = descripcion;
		this.valor = valor;
		this.idUsuario = idUsuario;
	}

	public BigDecimal getIdParametro() {
		return idParametro;
	}

	public void setIdParametro(BigDecimal idParametro) {
		this.idParametro = idParametro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String toString() {
		
		return this.idParametro.toString()  + " - " +  this.descripcion  + " - " +  this.valor  + " - " +  this.idUsuario;
		
	}
	
	public Object Clone() {
		
		return this.Clone();
		
	}

}
