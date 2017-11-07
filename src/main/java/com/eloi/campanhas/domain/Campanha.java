package com.eloi.campanhas.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Campanha {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@NotNull
	@ManyToOne(cascade = { CascadeType.ALL })
	private Clube timeCoracao;
	
	private LocalDateTime dataVigencia;

	public Campanha(String nome, Clube timeCoracao, LocalDateTime dataVigencia) {
		super();
		this.nome = nome;
		this.timeCoracao = timeCoracao;
		this.dataVigencia = dataVigencia;
	}
	public Campanha() {}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Clube getTimeCoracao() {
		return timeCoracao;
	}

	public LocalDateTime getDataVigencia() {
		return dataVigencia;
	}
	public void defineClube(Clube clube) {
		this.timeCoracao = clube;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
