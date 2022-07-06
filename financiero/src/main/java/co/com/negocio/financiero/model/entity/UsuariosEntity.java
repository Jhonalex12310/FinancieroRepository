package co.com.negocio.financiero.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity (name = "usuarios")
@Table(schema = "controlfinanciero", name = "usuarios")
@NamedQueries({
	@NamedQuery(name="UsuariosEntity.findAll",query= "SELECT a FROM usuarios a"),
	@NamedQuery(name="UsuariosEntity.findById",query= "SELECT a FROM usuarios a where a.id = :tipo")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosEntity  {	
	
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
			
}
