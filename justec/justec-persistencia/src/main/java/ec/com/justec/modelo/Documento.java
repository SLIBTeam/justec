package ec.com.justec.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "DOCUMENTO" database table.
 * 
 */
@Entity
@Table(name="\"DOCUMENTO\"")
@NamedQuery(name="Documento.findAll", query="SELECT d FROM Documento d")
public class Documento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DOCUMENTO_CODIGODOC_GENERATOR", sequenceName="SEQ_DOCUMENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCUMENTO_CODIGODOC_GENERATOR")
	@Column(name="\"CODIGO_DOC\"")
	private Integer codigoDoc;

	@Column(name="\"ESTADO_DOC\"")
	private String estadoDoc;

	@Temporal(TemporalType.DATE)
	@Column(name="\"FECHA_ACT_DOC\"")
	private Date fechaActDoc;

	@Temporal(TemporalType.DATE)
	@Column(name="\"FECHA_FIRMA_DOC\"")
	private Date fechaFirmaDoc;

	@Temporal(TemporalType.DATE)
	@Column(name="\"FECHA_PUBLICACION_DOC\"")
	private Date fechaPublicacionDoc;

	@Column(name="\"NUMERO_DOC\"")
	private Integer numeroDoc;

	@Column(name="\"RUTA_DOC\"")
	private String rutaDoc;

	@Column(name="\"TITULO_DOC\"")
	private String tituloDoc;

	//bi-directional many-to-one association to Materia
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="\"CODIGO_MAT\"")
	private Materia materia;

	//bi-directional many-to-one association to Seccion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="\"CODIGO_SEC\"")
	private Seccion seccion;

	//bi-directional many-to-one association to TipoNorma
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="\"CODIGO_TN\"")
	private TipoNorma tipoNorma;

	//bi-directional many-to-one association to TipoPublicacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="\"CODIGO_TP\"")
	private TipoPublicacion tipoPublicacion;

	//bi-directional many-to-one association to ResultadoBusqueda
	@OneToMany(mappedBy="documento")
	private List<ResultadoBusqueda> resultadoBusquedas;

	public Documento() {
	}

	public Integer getCodigoDoc() {
		return this.codigoDoc;
	}

	public void setCodigoDoc(Integer codigoDoc) {
		this.codigoDoc = codigoDoc;
	}

	public String getEstadoDoc() {
		return this.estadoDoc;
	}

	public void setEstadoDoc(String estadoDoc) {
		this.estadoDoc = estadoDoc;
	}

	public Date getFechaActDoc() {
		return this.fechaActDoc;
	}

	public void setFechaActDoc(Date fechaActDoc) {
		this.fechaActDoc = fechaActDoc;
	}

	public Date getFechaFirmaDoc() {
		return this.fechaFirmaDoc;
	}

	public void setFechaFirmaDoc(Date fechaFirmaDoc) {
		this.fechaFirmaDoc = fechaFirmaDoc;
	}

	public Date getFechaPublicacionDoc() {
		return this.fechaPublicacionDoc;
	}

	public void setFechaPublicacionDoc(Date fechaPublicacionDoc) {
		this.fechaPublicacionDoc = fechaPublicacionDoc;
	}

	public Integer getNumeroDoc() {
		return this.numeroDoc;
	}

	public void setNumeroDoc(Integer numeroDoc) {
		this.numeroDoc = numeroDoc;
	}

	public String getRutaDoc() {
		return this.rutaDoc;
	}

	public void setRutaDoc(String rutaDoc) {
		this.rutaDoc = rutaDoc;
	}

	public String getTituloDoc() {
		return this.tituloDoc;
	}

	public void setTituloDoc(String tituloDoc) {
		this.tituloDoc = tituloDoc;
	}

	public Materia getMateria() {
		return this.materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Seccion getSeccion() {
		return this.seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public TipoNorma getTipoNorma() {
		return this.tipoNorma;
	}

	public void setTipoNorma(TipoNorma tipoNorma) {
		this.tipoNorma = tipoNorma;
	}

	public TipoPublicacion getTipoPublicacion() {
		return this.tipoPublicacion;
	}

	public void setTipoPublicacion(TipoPublicacion tipoPublicacion) {
		this.tipoPublicacion = tipoPublicacion;
	}

	public List<ResultadoBusqueda> getResultadoBusquedas() {
		return this.resultadoBusquedas;
	}

	public void setResultadoBusquedas(List<ResultadoBusqueda> resultadoBusquedas) {
		this.resultadoBusquedas = resultadoBusquedas;
	}

	public ResultadoBusqueda addResultadoBusqueda(ResultadoBusqueda resultadoBusqueda) {
		getResultadoBusquedas().add(resultadoBusqueda);
		resultadoBusqueda.setDocumento(this);

		return resultadoBusqueda;
	}

	public ResultadoBusqueda removeResultadoBusqueda(ResultadoBusqueda resultadoBusqueda) {
		getResultadoBusquedas().remove(resultadoBusqueda);
		resultadoBusqueda.setDocumento(null);

		return resultadoBusqueda;
	}

}