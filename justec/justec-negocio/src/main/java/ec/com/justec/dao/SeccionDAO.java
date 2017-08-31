package ec.com.justec.dao;

import java.util.List;

import ec.com.justec.modelo.Seccion;

public interface SeccionDAO extends GenericDAO<Seccion, Integer> {

	/**
	 * Metodo que obtiene todas las secciones en estado Activo
	 * 
	 * @return
	 */
	List<Seccion> obtenerSecciones();

}
