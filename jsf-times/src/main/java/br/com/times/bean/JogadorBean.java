package br.com.times.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.times.dao.JogadorDAO;
import br.com.times.dao.PosicaoDAO;
import br.com.times.dao.TimeDAO;
import br.com.times.modelo.Jogador;
import br.com.times.modelo.Posicao;
import br.com.times.modelo.Time;
import br.com.times.transaction.Transactional;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class JogadorBean implements Serializable {

	private Jogador jogador = new Jogador();

	private Long posicaoId;

	private Long timeId;

	@Inject
	private JogadorDAO jogadorDAO;

	@Inject
	private PosicaoDAO posicaoDAO;

	@Inject
	private TimeDAO timeDAO;

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Long getPosicaoId() {
		return posicaoId;
	}

	public void setPosicaoId(Long posicaoId) {
		this.posicaoId = posicaoId;
	}

	public Long getTimeId() {
		return timeId;
	}

	public void setTimeId(Long timeId) {
		this.timeId = timeId;
	}

	public List<Posicao> getPosicoes() {
		return this.posicaoDAO.findAll();
	}

	public List<Time> getTimes() {
		return this.timeDAO.findAll();
	}

	public List<Jogador> getJogadores() {
		return this.jogadorDAO.findAll();
	}

	public List<Posicao> getPosicoesJogador() {
		return this.jogador.getPosicao();
	}

	public void gravarPosicao() {
		Posicao p = this.posicaoDAO.findById(this.posicaoId);

		this.jogador.addPosicao(p);
		
	}

	public void removerPosicaoDoJogador(Posicao p) {
		this.jogador.removerPosicao(p);
	}

	public String formPosicao() {
		return "posicao?faces-redirect=true";
	}

	public void carregar(Jogador jogador) {
		this.jogador = this.jogadorDAO.findById(jogador.getId());
	}

	@Transactional
	public String gravar() {

		if (this.timeId != null) {
			this.jogador.setTime(this.timeDAO.findById(this.timeId));
		}

		if (this.jogador.getId() == null) {
			this.jogadorDAO.save(jogador);
		} else {
			this.jogadorDAO.update(jogador);
		}

		return "jogador?faces-redirect=true";

	}
	
	@Transactional
	public void remover(Jogador jogador) {
		this.jogadorDAO.remove(jogador);
	}

}
