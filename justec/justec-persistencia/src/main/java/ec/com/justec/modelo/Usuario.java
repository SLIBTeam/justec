package ec.com.justec.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "USUARIO" database table.
 * 
 */
@Entity
@Table(name="\"USUARIO\"")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_CODIGOUS_GENERATOR", sequenceName="SEQ_USUARIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_CODIGOUS_GENERATOR")
	@Column(name="\"CODIGO_US\"")
	private Integer codigoUs;

	@Column(name="\"ESTADO_US\"")
	private String estadoUs;

	@Temporal(TemporalType.DATE)
	@Column(name="\"FECHA_ACT_US\"")
	private Date fechaActUs;

	@Column(name="\"NOMBRE_US\"")
	private String nombreUs;

	//bi-directional many-to-one association to ResultadoBusqueda
//	@OneToMany(mappedBy="usuario")
//	private List<ResultadoBusqueda> resultadoBusquedas;

	//bi-directional many-to-one association to UsuarioClave
	@OneToMany(mappedBy="usuario")
	private List<UsuarioClave> usuarioClaves;

	//bi-directional many-to-one association to UsuarioRol
	@OneToMany(mappedBy="usuario")
	private List<UsuarioRol> usuarioRols;

	public Usuario() {
	}

	public Integer getCodigoUs() {
		return this.codigoUs;
	}

	public void setCodigoUs(Integer codigoUs) {
		this.codigoUs = codigoUs;
	}

	public String getEstadoUs() {
		return this.estadoUs;
	}

	public void setEstadoUs(String estadoUs) {
		this.estadoUs = estadoUs;
	}

	public Date getFechaActUs() {
		return this.fechaActUs;
	}

	public void setFechaActUs(Date fechaActUs) {
		this.fechaActUs = fechaActUs;
	}

	public String getNombreUs() {
		return this.nombreUs;
	}

	public void setNombreUs(String nombreUs) {
		this.nombreUs = nombreUs;
	}

//	public List<ResultadoBusqueda> getResultadoBusquedas() {
//		return this.resultadoBusquedas;
//	}
//
//	public void setResultadoBusquedas(List<ResultadoBusqueda> resultadoBusquedas) {
//		this.resultadoBusquedas = resultadoBusquedas;
//	}

//	public ResultadoBusqueda addResultadoBusqueda(ResultadoBusqueda resultadoBusqueda) {
//		getResultadoBusquedas().add(resultadoBusqueda);
//		resultadoBusqueda.setUsuario(this);
//
//		return resultadoBusqueda;
//	}
//
//	public ResultadoBusqueda removeResultadoBusqueda(ResultadoBusqueda resultadoBusqueda) {
//		getResultadoBusquedas().remove(resultadoBusqueda);
//		resultadoBusqueda.setUsuario(null);
//
//		return resultadoBusqueda;
//	}

	public List<UsuarioClave> getUsuarioClaves() {
		return this.usuarioClaves;
	}

	public void setUsuarioClaves(List<UsuarioClave> usuarioClaves) {
		this.usuarioClaves = usuarioClaves;
	}

	public UsuarioClave addUsuarioClave(UsuarioClave usuarioClave) {
		getUsuarioClaves().add(usuarioClave);
		usuarioClave.setUsuario(this);

		return usuarioClave;
	}

	public UsuarioClave removeUsuarioClave(UsuarioClave usuarioClave) {
		getUsuarioClaves().remove(usuarioClave);
		usuarioClave.setUsuario(null);

		return usuarioClave;
	}

	public List<UsuarioRol> getUsuarioRols() {
		return this.usuarioRols;
	}

	public void setUsuarioRols(List<UsuarioRol> usuarioRols) {
		this.usuarioRols = usuarioRols;
	}

	public UsuarioRol addUsuarioRol(UsuarioRol usuarioRol) {
		getUsuarioRols().add(usuarioRol);
		usuarioRol.setUsuario(this);

		return usuarioRol;
	}

	public UsuarioRol removeUsuarioRol(UsuarioRol usuarioRol) {
		getUsuarioRols().remove(usuarioRol);
		usuarioRol.setUsuario(null);

		return usuarioRol;
	}

}