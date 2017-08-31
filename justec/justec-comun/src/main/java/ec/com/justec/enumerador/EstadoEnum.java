package ec.com.justec.enumerador;

public enum EstadoEnum {

	ACTIVO("1"), INACTIVO("0");

	private String label;

	EstadoEnum(String label) {
		this.label = label;
	}

	/**
	 * @return el valor de la variable label
	 */
	public String getLabel() {
		return label;
	}
}
