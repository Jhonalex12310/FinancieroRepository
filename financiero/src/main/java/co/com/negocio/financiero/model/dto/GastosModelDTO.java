package co.com.negocio.financiero.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class GastosModelDTO implements Serializable{
	
	private final static long serialVersionUID = 1L;
	private BigDecimal idGastos;
	private String descripcion;
	private BigDecimal valor;
	private String quincenaUno;
	private String quincenaDos;
	private String efectivo;
	private String usuario;
	private String valorToString;
	
	public GastosModelDTO() {
		
	}
	
	public GastosModelDTO(BigDecimal idGastos, String descripcion, BigDecimal valor, String quincenaUno,
			String quincenaDos, String efectivo, String usuario, String valorToString) {
		super();
		this.idGastos = idGastos;
		this.descripcion = descripcion;
		this.valor = valor;
		this.quincenaUno = quincenaUno;
		this.quincenaDos = quincenaDos;
		this.efectivo = efectivo;
		this.usuario = usuario;
		this.valorToString = valorToString;
	}
	public BigDecimal getIdGastos() {
		return idGastos;
	}
	public void setIdGastos(BigDecimal idGastos) {
		this.idGastos = idGastos;
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
	public String getQuincenaUno() {
		return quincenaUno;
	}
	public void setQuincenaUno(String quincenaUno) {
		this.quincenaUno = quincenaUno;
	}
	public String getQuincenaDos() {
		return quincenaDos;
	}
	public void setQuincenaDos(String quincenaDos) {
		this.quincenaDos = quincenaDos;
	}
	public String getEfectivo() {
		return efectivo;
	}
	public void setEfectivo(String efectivo) {
		this.efectivo = efectivo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getValorToString() {
		return valorToString;
	}

	public void setValorToString(String valorToString) {
		this.valorToString = valorToString;
	}

	public Object Clone() {
		
		return this.Clone();
		
	}
	
	public String toString() {
		
		return this.idGastos.toString()  + " - " +  this.descripcion  + " - " +  this.valor.toString()  + " - " +  this.quincenaUno  + " - " +  this.quincenaDos  + " - " + this.efectivo  + " - " + this.usuario + " - " + this.valorToString ;
	}
	

}
