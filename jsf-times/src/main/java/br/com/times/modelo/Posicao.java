package br.com.times.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Posicao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "VARCHAR(50) NOT NULL UNIQUE")
	private String nome_posicao;
	
	@Column(columnDefinition = "TEXT DEFAULT('Sem detalhes adicionais')", insertable = false, updatable = true)
	private String detalhes_posicao;
	
	public String getNome_posicao() {
		return nome_posicao;
	}

	public void setNome_posicao(String nome_posicao) {
		this.nome_posicao = nome_posicao;
	}

	public String getDetalhes_posicao() {
		return detalhes_posicao;
	}

	public void setDetalhes_posicao(String detalhes_posicao) {
		this.detalhes_posicao = detalhes_posicao;
	}

	public Long getId() {
		return id;
	}

	public Posicao() {
			
	}

	public Posicao(String nome_posicao, String detalhes_posicao) {
		super();
		this.nome_posicao = nome_posicao;
		this.detalhes_posicao = detalhes_posicao;
	}

	public Posicao(Long id, String nome_posicao, String detalhes_posicao) {
		super();
		this.id = id;
		this.nome_posicao = nome_posicao;
		this.detalhes_posicao = detalhes_posicao;
	}

	public Posicao(String nome_posicao) {
		super();
		this.nome_posicao = nome_posicao;
	}

	public Posicao(Long id, String nome_posicao) {
		super();
		this.id = id;
		this.nome_posicao = nome_posicao;
	}
	
	
		
}
