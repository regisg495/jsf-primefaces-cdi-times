package br.com.times.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.times.modelo.Posicao;

@SuppressWarnings("serial")
public class PosicaoDAO implements Serializable {

	@Inject
	private EntityManager em;
	
	private DAO<Posicao> posicaoDAO;
	
	@PostConstruct
	public void init() {
		this.posicaoDAO = new DAO<Posicao>(this.em, Posicao.class);
	}

	public void save(Posicao t) {
		posicaoDAO.save(t);
	}

	public void remove(Posicao t) {
		posicaoDAO.remove(t);
	}

	public void update(Posicao t) {
		posicaoDAO.update(t);
	}

	public List<Posicao> findAll() {
		return posicaoDAO.findAll();
	}

	public Posicao findById(Long id) {
		return posicaoDAO.findById(id);
	}

	public List<Posicao> loadPage(int firstResult, int maxResults) {
		return posicaoDAO.loadPage(firstResult, maxResults);
	}
	
	
}
