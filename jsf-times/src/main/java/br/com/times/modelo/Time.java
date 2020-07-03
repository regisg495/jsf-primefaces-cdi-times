package br.com.times.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Time {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "VARCHAR(200) NOT NULL UNIQUE")
	private String nome;
	
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "time")
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	
	@OneToOne(mappedBy = "time")
	private Tecnico tecnico;

	public Time() {
		
	}
	
	public Time(String nome, List<Jogador> jogadores, Tecnico tecnico) {
		super();
		this.nome = nome;
		this.jogadores = jogadores;
		this.tecnico = tecnico;
	}

	public Time(Long id, String nome, List<Jogador> jogadores, Tecnico tecnico) {
		super();
		this.id = id;
		this.nome = nome;
		this.jogadores = jogadores;
		this.tecnico = tecnico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void addJogador(Jogador jogador) {
		this.jogadores.add(jogador);
	}
	
	public void removeJogador(Jogador jogador) {
		this.jogadores.remove(jogador);
	}
	

}
