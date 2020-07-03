package br.com.times.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.times.dao.JogadorDAO;
import br.com.times.dao.TecnicoDAO;
import br.com.times.dao.TimeDAO;
import br.com.times.modelo.Jogador;
import br.com.times.modelo.Tecnico;
import br.com.times.modelo.Time;
import br.com.times.transaction.Transactional;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class TimeBean implements Serializable {

	private Time time = new Time();

	private Long tecnicoId;

	private Long jogadorId;

	@Inject
	private TimeDAO timeDAO;

	@Inject
	private TecnicoDAO tecnicoDAO;
	
	@Inject
	private JogadorDAO jogadorDAO;

	public List<Tecnico> getTecnicos() {
		return this.tecnicoDAO.findAll();
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Long getTecnicoId() {
		return tecnicoId;
	}

	public void setTecnicoId(Long tecnicoId) {
		this.tecnicoId = tecnicoId;
	}

	public Long getJogadorId() {
		return jogadorId;
	}

	public void setJogadorId(Long jogadorId) {
		this.jogadorId = jogadorId;
	}

	public List<Jogador> JogadoresCadastrados() {
		return this.time.getJogadores();
	}
	
	public List<Jogador> getJogadores() {
		return this.jogadorDAO.findAll();
	}
	
	public List<Time> getTimes() {
		return this.timeDAO.findAll();
	}

	@Transactional
	public String gravar() {
		if (this.tecnicoId != null) {
			this.time.setTecnico(this.tecnicoDAO.findById(this.tecnicoId));
		}

		if (this.time.getId() == null) {
			this.timeDAO.save(this.time);
		} else {
			this.timeDAO.update(this.time);
		}

		return "time?faces-redirect=true";
	}
	
	public void gravarJogador() {
		Jogador jogador = this.jogadorDAO.findById(this.jogadorId);
		
		this.time.addJogador(jogador);
	}
	
	public String formJogador() {
		return "jogador?faces-redirect=true";
	}
	
	public void removerJogadorDoTime(Jogador jogador) {
		this.time.removeJogador(jogador);
	}

	public void carregar(Time time) {
		this.time = this.timeDAO.findById(time.getId());
		this.tecnicoId = time.getTecnico().getId();
	}
	
	@Transactional
	public void remover(Time time) {
		this.timeDAO.remove(time);
	}
	
}
