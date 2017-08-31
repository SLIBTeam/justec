package ec.com.justec.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "USUARIO_ROL" database table.
 * 
 */
@Entity
@Table(name="\"USUARIO_ROL\"")
@NamedQuery(name="UsuarioRol.findAll", query="SELECT u FROM UsuarioRol u")
public class UsuarioRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_ROL_CODIGOUSR_GENERATOR", sequenceName="SEQ_USUARIO_ROL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_ROL_CODIGOUSR_GENERATOR")
	@Column(name="\"CODIGO_USR\"")
	private Integer codigoUsr;

	@Column(name="\"ESTADO_USR\"")
	private String estadoUsr;

	@Temporal(TemporalType.DATE)
	@Column(name="\"FECHA_ACT_USR\"")
	private Date fechaActUsr;

	//bi-directional many-to-one association to Rol
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="\"CODIGO_ROL\"")
	private Rol rol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="\"CODIGO_US\"")
	private Usuario usuario;

	public UsuarioRol() {
	}

	public Integer getCodigoUsr() {
		return this.codigoUsr;
	}

	public void setCodigoUsr(Integer codigoUsr) {
		this.codigoUsr = codigoUsr;
	}

	public String getEstadoUsr() {
		return this.estadoUsr;
	}

	public void setEstadoUsr(String estadoUsr) {
		this.estadoUsr = estadoUsr;
	}

	public Date getFechaActUsr() {
		return this.fechaActUsr;
	}

	public void setFechaActUsr(Date fechaActUsr) {
		this.fechaActUsr = fechaActUsr;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}