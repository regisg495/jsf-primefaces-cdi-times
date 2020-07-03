package br.com.times.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.times.modelo.Jogador;
import br.com.times.modelo.Time;

@SuppressWarnings("serial")
public class JogadorDAO implements Serializable {
	
	@Inject
	private EntityManager em;
	
	private DAO<Jogador> jogadorDAO;
	
	@PostConstruct
	public void init() {
		this.jogadorDAO = new DAO<Jogador>(this.em, Jogador.class);
	}

	public void save(Jogador t) {
		jogadorDAO.save(t);
	}

	public void remove(Jogador t) {
		jogadorDAO.remove(t);
	}

	public void update(Jogador t) {
		jogadorDAO.update(t);
	}

	public List<Jogador> findAll() {
		return jogadorDAO.findAll();
	}

	public Jogador findById(Long id) {
		return jogadorDAO.findById(id);
	}

	public List<Jogador> loadPage(int firstResult, int maxResults) {
		return jogadorDAO.loadPage(firstResult, maxResults);
	}
	
	@SuppressWarnings("unchecked")
	public List<Jogador> findByTime(Time time) {
		
		this.em.getTransaction().begin();
		
		Query query = this.em.createQuery("FROM Jogador WHERE time_id = :tId");
		query.setParameter("tId", time.getId());
		
		List<Jogador> jogadores = query.getResultList();
		
		this.em.getTransaction().commit();
		
		return jogadores;
	}
}
