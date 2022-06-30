package co.com.negocio.financiero.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UsuariosModelDTO implements Serializable{
	
	private final static long serialVersionUID = 1L;
	
	private BigDecimal idUsuario;
	private String estadoUsuario;
	private String nombreUsuario;
	private BigDecimal conteo;
	private BigDecimal salario;
	private Date fecha;
	
	public UsuariosModelDTO() {
		
	}
	
	public UsuariosModelDTO(BigDecimal idUsuario, String estadoUsuario, String nombreUsuario, BigDecimal conteo,
			BigDecimal salario, Date fecha) {
		super();
		this.idUsuario = idUsuario;
		this.estadoUsuario = estadoUsuario;
		this.nombreUsuario = nombreUsuario;
		this.conteo = conteo;
		this.salario = salario;
		this.fecha = fecha;
	}
	public BigDecimal getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(BigDecimal idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEstadoUsuario() {
		return estadoUsuario;
	}
	public void setEstadoUsuario(String estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public BigDecimal getConteo() {
		return conteo;
	}
	public void setConteo(BigDecimal conteo) {
		this.conteo = conteo;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Object clone() {
		
		return this.clone();
		
	}
	
	public String toString() {
		
		return this.idUsuario.toString()  + " - " +  this.estadoUsuario  + " - " +  this.nombreUsuario  + " - " +  this.conteo.toString()  + " - " +  this.salario.toString()  + " - " + this.fecha ;
	}
	
}
