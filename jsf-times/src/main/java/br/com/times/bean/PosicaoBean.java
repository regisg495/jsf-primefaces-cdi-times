package br.com.times.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.times.dao.PosicaoDAO;
import br.com.times.modelo.Posicao;
import br.com.times.transaction.Transactional;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class PosicaoBean implements Serializable {

	private Posicao posicao = new Posicao();

	@Inject
	private PosicaoDAO posicaoDAO;
	

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public List<Posicao> getPosicoes() {
		return this.posicaoDAO.findAll();
	}

	@Transactional
	public String gravar() {

		if (this.posicao.getId() == null) {
			this.posicaoDAO.save(this.posicao);
		} else {
			this.posicaoDAO.update(this.posicao);
		}

		return "posicao?faces-redirect=true";

	}
	
	@Transactional
	public void remover(Posicao posicao) {
		this.posicaoDAO.remove(posicao);
	}
	
	public void carregar(Posicao posicao) {
		this.posicao = this.posicaoDAO.findById(posicao.getId());
	}

}