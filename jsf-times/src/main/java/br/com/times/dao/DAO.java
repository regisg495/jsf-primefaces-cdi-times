package br.com.times.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

@SuppressWarnings("serial")
public class DAO<T> implements Serializable {

	private final Class<T> clazz;
	private EntityManager em;

	public DAO(EntityManager em, Class<T> clazz) {
		this.em = em;
		this.clazz = clazz;
	}

	public void save(T t) {
		em.persist(t);
	}

	public void remove(T t) {
		em.remove(em.merge(t));
	}

	public void update(T t) {
		em.merge(t);
	}

	public List<T> findAll() {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(clazz);
		query.select(query.from(clazz));

		List<T> list = em.createQuery(query).getResultList();

		return list;
	}

	public T findById(Long id) {
		T instance = em.find(clazz, id);
		return instance;
	}


	public List<T> loadPage(int firstResult, int maxResults) {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(clazz);
		query.select(query.from(clazz));

		List<T> lista = em.createQuery(query).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();

		return lista;
	}

}
