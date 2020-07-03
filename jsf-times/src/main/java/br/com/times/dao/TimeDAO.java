package br.com.times.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.times.modelo.Time;

@SuppressWarnings("serial")
public class TimeDAO implements Serializable {
	
	@Inject
	private EntityManager em;
	
	private DAO<Time> timeDAO;
	
	@PostConstruct
	public void init() {
		this.timeDAO = new DAO<Time>(this.em, Time.class);
	}

	public void save(Time t) {
		timeDAO.save(t);
	}

	public void remove(Time t) {
		timeDAO.remove(t);
	}

	public void update(Time t) {
		timeDAO.update(t);
	}

	public List<Time> findAll() {
		return timeDAO.findAll();
	}

	public Time findById(Long id) {
		return timeDAO.findById(id);
	}

	public List<Time> loadPage(int firstResult, int maxResults) {
		return timeDAO.loadPage(firstResult, maxResults);
	}

}
