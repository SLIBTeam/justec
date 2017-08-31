package ec.com.justec.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "MATERIA" database table.
 * 
 */
@Entity
@Table(name="\"MATERIA\"")
@NamedQuery(name="Materia.findAll", query="SELECT m FROM Materia m")
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MATERIA_CODIGOMAT_GENERATOR", sequenceName="SEQ_MATERIA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MATERIA_CODIGOMAT_GENERATOR")
	@Column(name="\"CODIGO_MAT\"")
	private Integer codigoMat;

	@Column(name="\"ESTADO_MAT\"")
	private String estadoMat;

	@Temporal(TemporalType.DATE)
	@Column(name="\"FECHA_ACT_MAT\"")
	private Date fechaActMat;

	@Column(name="\"NOMBRE_MAT\"")
	private String nombreMat;

	//bi-directional many-to-one association to Documento
	@OneToMany(mappedBy="materia")
	private List<Documento> documentos;

	public Materia() {
	}

	public Integer getCodigoMat() {
		return this.codigoMat;
	}

	public void setCodigoMat(Integer codigoMat) {
		this.codigoMat = codigoMat;
	}

	public String getEstadoMat() {
		return this.estadoMat;
	}

	public void setEstadoMat(String estadoMat) {
		this.estadoMat = estadoMat;
	}

	public Date getFechaActMat() {
		return this.fechaActMat;
	}

	public void setFechaActMat(Date fechaActMat) {
		this.fechaActMat = fechaActMat;
	}

	public String getNombreMat() {
		return this.nombreMat;
	}

	public void setNombreMat(String nombreMat) {
		this.nombreMat = nombreMat;
	}

	public List<Documento> getDocumentos() {
		return this.documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public Documento addDocumento(Documento documento) {
		getDocumentos().add(documento);
		documento.setMateria(this);

		return documento;
	}

	public Documento removeDocumento(Documento documento) {
		getDocumentos().remove(documento);
		documento.setMateria(null);

		return documento;
	}

}