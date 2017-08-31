package ec.com.justec.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "SECCION" database table.
 * 
 */
@Entity
@Table(name="\"SECCION\"")
@NamedQuery(name="Seccion.findAll", query="SELECT s FROM Seccion s")
public class Seccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECCION_CODIGOSEC_GENERATOR", sequenceName="SEQ_SECCION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECCION_CODIGOSEC_GENERATOR")
	@Column(name="\"CODIGO_SEC\"")
	private Integer codigoSec;

	@Column(name="\"ESTADO_SEC\"")
	private String estadoSec;

	@Temporal(TemporalType.DATE)
	@Column(name="\"FECHA_ACT_SEC\"")
	private Date fechaActSec;

	@Column(name="\"NOMBRE_SEC\"")
	private String nombreSec;

	//bi-directional many-to-one association to Documento
	@OneToMany(mappedBy="seccion")
	private List<Documento> documentos;

	public Seccion() {
	}

	public Integer getCodigoSec() {
		return this.codigoSec;
	}

	public void setCodigoSec(Integer codigoSec) {
		this.codigoSec = codigoSec;
	}

	public String getEstadoSec() {
		return this.estadoSec;
	}

	public void setEstadoSec(String estadoSec) {
		this.estadoSec = estadoSec;
	}

	public Date getFechaActSec() {
		return this.fechaActSec;
	}

	public void setFechaActSec(Date fechaActSec) {
		this.fechaActSec = fechaActSec;
	}

	public String getNombreSec() {
		return this.nombreSec;
	}

	public void setNombreSec(String nombreSec) {
		this.nombreSec = nombreSec;
	}

	public List<Documento> getDocumentos() {
		return this.documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public Documento addDocumento(Documento documento) {
		getDocumentos().add(documento);
		documento.setSeccion(this);

		return documento;
	}

	public Documento removeDocumento(Documento documento) {
		getDocumentos().remove(documento);
		documento.setSeccion(null);

		return documento;
	}

}