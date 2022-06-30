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

@Entity (name = "gastos")
@Table(schema = "controlfinanciero", name = "gastos")
@NamedQueries({
	@NamedQuery(name="GastosEntity.findAll",query= "SELECT a FROM gastos a"),
	@NamedQuery(name="GastosEntity.findById",query= "SELECT b FROM gastos b WHERE idusuario = :tipo")
})
public class GastosEntity  implements Serializable{
	
	private static final long serialVersionUID = -2254217774826292186L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idgastos", nullable=true)
	private BigDecimal idGastos;
	
	@Column(name="descripcion", nullable=false)
	private String descripcion;
	
	@Column(name="valor", nullable=false)
	private BigDecimal valor;
	
	@Column(name="quincena1", nullable=false)
	private String quincenaUno;
	
	@Column(name="quincena2", nullable=false)
	private String quincenaDos;
	
	@Column(name="efectivo", nullable=false)
	private String efectivo;
	
	@Column(name="idusuario", nullable=false)
	private String usuario;

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

		
}
