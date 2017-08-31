package ec.com.justec.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "TIPO_ROL" database table.
 * 
 */
@Entity
@Table(name="\"TIPO_ROL\"")
@NamedQuery(name="TipoRol.findAll", query="SELECT t FROM TipoRol t")
public class TipoRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_ROL_CODIGOTR_GENERATOR", sequenceName="SEQ_TIPO_ROL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_ROL_CODIGOTR_GENERATOR")
	@Column(name="\"CODIGO_TR\"")
	private Integer codigoTr;

	@Column(name="\"ESTADO_TR\"")
	private String estadoTr;

	@Temporal(TemporalType.DATE)
	@Column(name="\"FECHA_ACT_TR\"")
	private Date fechaActTr;

	@Column(name="\"NOMBRE_TR\"")
	private String nombreTr;

	//bi-directional many-to-one association to Rol
	@OneToMany(mappedBy="tipoRol")
	private List<Rol> rols;

	public TipoRol() {
	}

	public Integer getCodigoTr() {
		return this.codigoTr;
	}

	public void setCodigoTr(Integer codigoTr) {
		this.codigoTr = codigoTr;
	}

	public String getEstadoTr() {
		return this.estadoTr;
	}

	public void setEstadoTr(String estadoTr) {
		this.estadoTr = estadoTr;
	}

	public Date getFechaActTr() {
		return this.fechaActTr;
	}

	public void setFechaActTr(Date fechaActTr) {
		this.fechaActTr = fechaActTr;
	}

	public String getNombreTr() {
		return this.nombreTr;
	}

	public void setNombreTr(String nombreTr) {
		this.nombreTr = nombreTr;
	}

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

	public Rol addRol(Rol rol) {
		getRols().add(rol);
		rol.setTipoRol(this);

		return rol;
	}

	public Rol removeRol(Rol rol) {
		getRols().remove(rol);
		rol.setTipoRol(null);

		return rol;
	}

}