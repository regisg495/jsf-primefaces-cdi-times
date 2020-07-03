package br.com.times.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Tecnico extends Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(unique = true)
	private Time time;
	
	

	public Long getId() {
		return id;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
	public Tecnico() {
		
	}

	public Tecnico(String nome, String cpf, Time time) {
		super(nome, cpf);
		this.time = time;
	}

	public Tecnico(String nome, String cpf, Long id, Time time) {
		super(nome, cpf);
		this.id = id;
		this.time = time;
	}

	public Tecnico(String nome, String cpf) {
		super(nome, cpf);
	}

	public Tecnico(Long id) {
		super();
		this.id = id;
	}

	
	
}
