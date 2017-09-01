package ec.com.justec.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.com.justec.dao.SeccionDAO;
import ec.com.justec.enumerador.EstadoEnum;
import ec.com.justec.modelo.Seccion;

@Stateless
public class SeccionDAOImpl extends GenericDAOImpl<Seccion, Integer> implements SeccionDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Seccion> obtenerSecciones() {
		Query q = em.createQuery("Select s from Seccion s where s.estadoSec = :estado");
		q.setParameter("estado", EstadoEnum.ACTIVO.getLabel());
		return q.getResultList();
	}

}
