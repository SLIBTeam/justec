package ec.com.justec.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "TIPO_NORMA" database table.
 * 
 */
@Entity
@Table(name="\"TIPO_NORMA\"")
@NamedQuery(name="TipoNorma.findAll", query="SELECT t FROM TipoNorma t")
public class TipoNorma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_NORMA_CODIGOTN_GENERATOR", sequenceName="SEQ_TIPO_NORMA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_NORMA_CODIGOTN_GENERATOR")
	@Column(name="\"CODIGO_TN\"")
	private Integer codigoTn;

	@Column(name="\"ESTADO_TN\"")
	private String estadoTn;

	@Temporal(TemporalType.DATE)
	@Column(name="\"FECHA_ACT_TN\"")
	private Date fechaActTn;

	@Column(name="\"NOMBRE_TN\"")
	private String nombreTn;

	//bi-directional many-to-one association to Documento
	@OneToMany(mappedBy="tipoNorma")
	private List<Documento> documentos;

	public TipoNorma() {
	}

	public Integer getCodigoTn() {
		return this.codigoTn;
	}

	public void setCodigoTn(Integer codigoTn) {
		this.codigoTn = codigoTn;
	}

	public String getEstadoTn() {
		return this.estadoTn;
	}

	public void setEstadoTn(String estadoTn) {
		this.estadoTn = estadoTn;
	}

	public Date getFechaActTn() {
		return this.fechaActTn;
	}

	public void setFechaActTn(Date fechaActTn) {
		this.fechaActTn = fechaActTn;
	}

	public String getNombreTn() {
		return this.nombreTn;
	}

	public void setNombreTn(String nombreTn) {
		this.nombreTn = nombreTn;
	}

	public List<Documento> getDocumentos() {
		return this.documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public Documento addDocumento(Documento documento) {
		getDocumentos().add(documento);
		documento.setTipoNorma(this);

		return documento;
	}

	public Documento removeDocumento(Documento documento) {
		getDocumentos().remove(documento);
		documento.setTipoNorma(null);

		return documento;
	}

}