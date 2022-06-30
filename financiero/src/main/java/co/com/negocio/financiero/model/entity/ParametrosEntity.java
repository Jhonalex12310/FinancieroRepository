package co.com.negocio.financiero.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity (name = "parametros")
@Table(schema = "controlfinanciero", name = "parametros")
@NamedQueries({
	@NamedQuery(name="ParametrosEntity.findAll",query= "SELECT a FROM parametros a"),
	@NamedQuery(name="ParametrosEntity.findById",query= "SELECT a FROM parametros a where id_usuario = :tipo")
})
public class ParametrosEntity implements Serializable {
	
	private static final long serialVersionUID = -2254217774826292187L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id_parametro", nullable=true)
	private BigDecimal idParametro;
	
	@Column(name="descripcion", nullable=false)
	private String descripcion;
	
	@Column(name="valor", nullable=false)
	private BigDecimal valor;
	
	@Column(name="id_usuario", nullable=false)
	private String idUsuario;

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

	
	
}
