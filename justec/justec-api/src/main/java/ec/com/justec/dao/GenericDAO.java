package ec.com.justec.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

	public T findById(ID id);

	public List<T> findAll();

	public T update(T entity) throws Exception;

	public void delete(T entity) throws Exception;

	public void delete(ID id) throws Exception;

	public void persist(T entity) throws Exception;

}
