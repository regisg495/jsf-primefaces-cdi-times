package br.com.times.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class Pessoa implements Serializable {

	@Column(columnDefinition = "VARCHAR(200) NOT NULL")
	private String nome;

	@Column(columnDefinition = "CHAR(11) NOT NULL UNIQUE")
	private String cpf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Pessoa() {

	}

	public Pessoa(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

}
