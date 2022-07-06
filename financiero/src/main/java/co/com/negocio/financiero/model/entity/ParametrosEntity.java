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

@Entity (name = "parametros")
@Table(schema = "controlfinanciero", name = "parametros")
@NamedQueries({
	@NamedQuery(name="ParametrosEntity.findAll",query= "SELECT a FROM parametros a"),
	@NamedQuery(name="ParametrosEntity.findById",query= "SELECT a FROM parametros a where id_usuario = :tipo")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParametrosEntity  {
	
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
	
}
