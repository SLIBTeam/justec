package ec.com.justec.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the "RESULTADO_BUSQUEDA" database table.
 * 
 */
@Entity
@Table(name="\"RESULTADO_BUSQUEDA\"")
@NamedQuery(name="ResultadoBusqueda.findAll", query="SELECT r FROM ResultadoBusqueda r")
public class ResultadoBusqueda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESULTADO_BUSQUEDA_CODIGORB_GENERATOR", sequenceName="SEQ_RESULTADO_BUSQUEDA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESULTADO_BUSQUEDA_CODIGORB_GENERATOR")
	@Column(name="\"CODIGO_RB\"")
	private Integer codigoRb;

	@Temporal(TemporalType.DATE)
	@Column(name="\"FECHA_RB\"")
	private Date fechaRb;

	@Column(name="\"TEXTO_RB\"")
	private String textoRb;

	@Column(name="\"USUARIO_RB\"")
	private Integer usuarioRb;

	//bi-directional many-to-one association to Documento
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="\"CODIGO_DOC\"")
	private Documento documento;

	//bi-directional many-to-one association to Usuario
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="\"CODIGO_RB\"")
//	private Usuario usuario;

	public ResultadoBusqueda() {
	}

	public Integer getCodigoRb() {
		return this.codigoRb;
	}

	public void setCodigoRb(Integer codigoRb) {
		this.codigoRb = codigoRb;
	}

	public Date getFechaRb() {
		return this.fechaRb;
	}

	public void setFechaRb(Date fechaRb) {
		this.fechaRb = fechaRb;
	}

	public String getTextoRb() {
		return this.textoRb;
	}

	public void setTextoRb(String textoRb) {
		this.textoRb = textoRb;
	}

	public Integer getUsuarioRb() {
		return this.usuarioRb;
	}

	public void setUsuarioRb(Integer usuarioRb) {
		this.usuarioRb = usuarioRb;
	}

	public Documento getDocumento() {
		return this.documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

//	public Usuario getUsuario() {
//		return this.usuario;
//	}
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}

}