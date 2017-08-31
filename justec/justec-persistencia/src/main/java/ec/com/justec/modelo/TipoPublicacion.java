package ec.com.justec.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "TIPO_PUBLICACION" database table.
 * 
 */
@Entity
@Table(name="\"TIPO_PUBLICACION\"")
@NamedQuery(name="TipoPublicacion.findAll", query="SELECT t FROM TipoPublicacion t")
public class TipoPublicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_PUBLICACION_CODIGOTP_GENERATOR", sequenceName="SEQ_TIPO_PUBLICACION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_PUBLICACION_CODIGOTP_GENERATOR")
	@Column(name="\"CODIGO_TP\"")
	private Integer codigoTp;

	@Column(name="\"ESTADO_TP\"")
	private String estadoTp;

	@Temporal(TemporalType.DATE)
	@Column(name="\"FECHA_ACT_TP\"")
	private Date fechaActTp;

	@Column(name="\"NOMBRE_TP\"")
	private String nombreTp;

	//bi-directional many-to-one association to Documento
	@OneToMany(mappedBy="tipoPublicacion")
	private List<Documento> documentos;

	public TipoPublicacion() {
	}

	public Integer getCodigoTp() {
		return this.codigoTp;
	}

	public void setCodigoTp(Integer codigoTp) {
		this.codigoTp = codigoTp;
	}

	public String getEstadoTp() {
		return this.estadoTp;
	}

	public void setEstadoTp(String estadoTp) {
		this.estadoTp = estadoTp;
	}

	public Date getFechaActTp() {
		return this.fechaActTp;
	}

	public void setFechaActTp(Date fechaActTp) {
		this.fechaActTp = fechaActTp;
	}

	public String getNombreTp() {
		return this.nombreTp;
	}

	public void setNombreTp(String nombreTp) {
		this.nombreTp = nombreTp;
	}

	public List<Documento> getDocumentos() {
		return this.documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public Documento addDocumento(Documento documento) {
		getDocumentos().add(documento);
		documento.setTipoPublicacion(this);

		return documento;
	}

	public Documento removeDocumento(Documento documento) {
		getDocumentos().remove(documento);
		documento.setTipoPublicacion(null);

		return documento;
	}

}