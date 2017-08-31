package ec.com.justec.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "PAIS" database table.
 * 
 */
@Entity
@Table(name="\"PAIS\"")
@NamedQuery(name="Pais.findAll", query="SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PAIS_CODIGOPAIS_GENERATOR", sequenceName="SEQ_PAIS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAIS_CODIGOPAIS_GENERATOR")
	@Column(name="\"CODIGO_PAIS\"")
	private Integer codigoPais;

	@Column(name="\"NOMBRE_PAIS\"")
	private String nombrePais;

	public Pais() {
	}

	public Integer getCodigoPais() {
		return this.codigoPais;
	}

	public void setCodigoPais(Integer codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getNombrePais() {
		return this.nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

}