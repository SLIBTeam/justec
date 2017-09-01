package ec.com.justec.servicios.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.justec.dao.SeccionDAO;
import ec.com.justec.modelo.Seccion;
import ec.com.justec.servicios.SeccionService;

@Stateless
public class SeccionServiceImpl implements SeccionService {

	@EJB
	private SeccionDAO seccionDAO;

	@Override
	public List<Seccion> obtenerSecciones() {
		return null;
	}

}
