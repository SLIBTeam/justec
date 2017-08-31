package ec.com.justec.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "USUARIO_CLAVE" database table.
 * 
 */
@Entity
@Table(name="\"USUARIO_CLAVE\"")
@NamedQuery(name="UsuarioClave.findAll", query="SELECT u FROM UsuarioClave u")
public class UsuarioClave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_CLAVE_CODIGOUSC_GENERATOR", sequenceName="SEQ_USUARIO_CLAVE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_CLAVE_CODIGOUSC_GENERATOR")
	@Column(name="\"CODIGO_USC\"")
	private Integer codigoUsc;

	@Column(name="\"CLAVE_USC\"")
	private String claveUsc;

	@Column(name="\"ESTADO_USC\"")
	private String estadoUsc;

	@Temporal(TemporalType.DATE)
	@Column(name="\"FECHA_ACT_USC\"")
	private Date fechaActUsc;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="\"CODIGO_US\"")
	private Usuario usuario;

	public UsuarioClave() {
	}

	public Integer getCodigoUsc() {
		return this.codigoUsc;
	}

	public void setCodigoUsc(Integer codigoUsc) {
		this.codigoUsc = codigoUsc;
	}

	public String getClaveUsc() {
		return this.claveUsc;
	}

	public void setClaveUsc(String claveUsc) {
		this.claveUsc = claveUsc;
	}

	public String getEstadoUsc() {
		return this.estadoUsc;
	}

	public void setEstadoUsc(String estadoUsc) {
		this.estadoUsc = estadoUsc;
	}

	public Date getFechaActUsc() {
		return this.fechaActUsc;
	}

	public void setFechaActUsc(Date fechaActUsc) {
		this.fechaActUsc = fechaActUsc;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}