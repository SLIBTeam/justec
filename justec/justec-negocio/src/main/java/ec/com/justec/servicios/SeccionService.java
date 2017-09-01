package ec.com.justec.servicios;

import java.util.List;

import javax.ejb.Local;

import ec.com.justec.modelo.Seccion;

@Local
public interface SeccionService {

	/**
	 * Metodo que obtiene las secciones activas
	 * @return
	 */
	List<Seccion> obtenerSecciones();

}
