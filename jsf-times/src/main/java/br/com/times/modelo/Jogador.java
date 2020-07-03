package br.com.times.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Jogador extends Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Time time;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Posicao> posicao = new ArrayList<Posicao>();
	
	public Long getId() {
		return id;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public List<Posicao> getPosicao() {
		return posicao;
	}

	public void setPosicao(List<Posicao> posicao) {
		this.posicao = posicao;
	}
	
	public void addPosicao(Posicao p) {
		
		if(!this.posicao.isEmpty()) {
		for(Posicao posicao : this.posicao) {
			if(posicao.getId() == p.getId()) {
				return;
			}
		}
	}
		
		this.posicao.add(p);
	}
	
	public void removerPosicao(Posicao p) {
		this.posicao.remove(p);
	}

	public Jogador() {
		
	}
	
	public Jogador(Long id, Time time) {
		super();
		this.id = id;
		this.time = time;
	}

	public Jogador(String nome, String cpf, Long id, Time time, List<Posicao> posicao) {
		super(nome, cpf);
		this.id = id;
		this.time = time;
		this.posicao = posicao;
	}

	public Jogador(String nome, String cpf, List<Posicao> posicao) {
		super(nome, cpf);
		this.posicao = posicao;
	}

	public Jogador(Time time, List<Posicao> posicao) {
		super();
		this.time = time;
		this.posicao = posicao;
	}
	
	public Jogador(String nome, String cpf, Time time, List<Posicao> posicao) {
		super(nome, cpf);
		this.time = time;
		this.posicao = posicao;
	}

}
