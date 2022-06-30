package co.com.negocio.financiero.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity (name = "usuarios")
@Table(schema = "controlfinanciero", name = "usuarios")
@NamedQueries({
	@NamedQuery(name="UsuariosEntity.findAll",query= "SELECT a FROM usuarios a"),
	@NamedQuery(name="UsuariosEntity.findById",query= "SELECT a FROM usuarios a where a.id = :tipo")
})
public class UsuariosEntity implements Serializable {
	
	private static final long serialVersionUID = -2254217774826292188L;
	
	@Id
	@Column(name="id", nullable=false)
	private BigDecimal idUsuario;
	
	@Column(name="estado_usuario", nullable=false)
	private String estadoUsuario;
	
	@Column(name="nombre_usuario", nullable=false)
	private String nombreUsuario;
	
	@Column(name="conteo", nullable=true)
	private BigDecimal conteo;
	
	@Column(name="salario", nullable=false)
	private BigDecimal salario;
	
	@Column(name="year", nullable=true)
	private String fecha;
	
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	
	
		
}
