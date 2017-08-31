package ec.com.justec.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "ROL" database table.
 * 
 */
@Entity
@Table(name="\"ROL\"")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROL_CODIGOROL_GENERATOR", sequenceName="SEQ_ROL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROL_CODIGOROL_GENERATOR")
	@Column(name="\"CODIGO_ROL\"")
	private Integer codigoRol;

	@Column(name="\"ESTADO_ROL\"")
	private String estadoRol;

	@Temporal(TemporalType.DATE)
	@Column(name="\"FECHA_ACT_ROL\"")
	private Date fechaActRol;

	@Column(name="\"NOMBRE_ROL\"")
	private String nombreRol;

	//bi-directional many-to-one association to TipoRol
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="\"CODIGO_TR\"")
	private TipoRol tipoRol;

	//bi-directional many-to-one association to UsuarioRol
	@OneToMany(mappedBy="rol")
	private List<UsuarioRol> usuarioRols;

	public Rol() {
	}

	public Integer getCodigoRol() {
		return this.codigoRol;
	}

	public void setCodigoRol(Integer codigoRol) {
		this.codigoRol = codigoRol;
	}

	public String getEstadoRol() {
		return this.estadoRol;
	}

	public void setEstadoRol(String estadoRol) {
		this.estadoRol = estadoRol;
	}

	public Date getFechaActRol() {
		return this.fechaActRol;
	}

	public void setFechaActRol(Date fechaActRol) {
		this.fechaActRol = fechaActRol;
	}

	public String getNombreRol() {
		return this.nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public TipoRol getTipoRol() {
		return this.tipoRol;
	}

	public void setTipoRol(TipoRol tipoRol) {
		this.tipoRol = tipoRol;
	}

	public List<UsuarioRol> getUsuarioRols() {
		return this.usuarioRols;
	}

	public void setUsuarioRols(List<UsuarioRol> usuarioRols) {
		this.usuarioRols = usuarioRols;
	}

	public UsuarioRol addUsuarioRol(UsuarioRol usuarioRol) {
		getUsuarioRols().add(usuarioRol);
		usuarioRol.setRol(this);

		return usuarioRol;
	}

	public UsuarioRol removeUsuarioRol(UsuarioRol usuarioRol) {
		getUsuarioRols().remove(usuarioRol);
		usuarioRol.setRol(null);

		return usuarioRol;
	}

}