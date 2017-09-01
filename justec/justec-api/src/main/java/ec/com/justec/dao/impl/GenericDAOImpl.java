package ec.com.justec.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.com.justec.dao.GenericDAO;

public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private final Class<T> persistentClass;

	@PersistenceContext
	protected EntityManager em;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Override
	public T findById(ID id) {
		return getEntityManager().find(persistentClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return getEntityManager().createQuery("select o from " + persistentClass.getCanonicalName() + " o")
				.getResultList();
	}

	@Override
	public T update(T entity) throws Exception {
		try {
			return getEntityManager().merge(entity);
		} catch (Throwable ex) {
			throw new Exception();
		}
	}

	@Override
	public void delete(T entity) throws Exception {
		try {
			getEntityManager().remove(getEntityManager().merge(entity));
		} catch (Throwable ex) {
			throw new Exception();
		}
	}

	@Override
	public void delete(ID id) throws Exception {
		T obj = findById(id);
		delete(obj);
	}

	@Override
	public void persist(T entity) throws Exception {
		try {
			getEntityManager().persist(entity);
		} catch (Throwable ex) {
			throw new Exception();
		}
	}

	public EntityManager getEntityManager() {
		return this.em;
	}

}
