package co.com.negocio.financiero.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity (name = "gastos")
@Table(schema = "controlfinanciero", name = "gastos")
@NamedQueries({
	@NamedQuery(name="GastosEntity.findAll",query= "SELECT a FROM gastos a"),
	@NamedQuery(name="GastosEntity.findById",query= "SELECT b FROM gastos b WHERE idusuario = :tipo")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GastosEntity{
	
	
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

	
}
