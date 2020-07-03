package br.com.times.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.times.modelo.Tecnico;


@SuppressWarnings("serial")
public class TecnicoDAO implements Serializable {

	@Inject
	private EntityManager em;
	
	private DAO<Tecnico> tecnicoDAO;
	
	@PostConstruct
	public void init() {
		this.tecnicoDAO = new DAO<Tecnico>(this.em, Tecnico.class);
	}

	public void save(Tecnico t) {
		tecnicoDAO.save(t);
	}

	public void remove(Tecnico t) {
		tecnicoDAO.remove(t);
	}

	public void update(Tecnico t) {
		tecnicoDAO.update(t);
	}

	public List<Tecnico> findAll() {
		return tecnicoDAO.findAll();
	}

	public Tecnico findById(Long id) {
		return tecnicoDAO.findById(id);
	}
	
	public List<Tecnico> loadPage(int firstResult, int maxResults) {
		return tecnicoDAO.loadPage(firstResult, maxResults);
	}
	
	
}
