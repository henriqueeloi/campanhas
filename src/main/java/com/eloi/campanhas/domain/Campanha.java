package com.eloi.campanhas.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.eloi.campanhas.infrastructure.exception.DataVigenciaVencidaException;

@Entity
public class Campanha {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@NotNull
	@ManyToOne(cascade = { CascadeType.ALL })
	private Clube timeCoracao;
	
	private LocalDateTime dataInicioVigencia;
	
	private LocalDateTime dataFimVigencia;

	public Campanha(String nome, Clube timeCoracao, LocalDateTime dataVigencia, LocalDateTime dataFimVigencia) {
		super();
		this.nome = nome;
		this.timeCoracao = timeCoracao;
		this.dataInicioVigencia = dataVigencia;
		this.dataFimVigencia = dataFimVigencia;
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
		return dataInicioVigencia;
	}
	public void defineClube(Clube clube) {
		this.timeCoracao = clube;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDataFimVigencia() {
		return dataFimVigencia;
	}

	public void validaDataVigente() {
		if(LocalDateTime.now().isAfter(this.getDataFimVigencia()))
			throw new DataVigenciaVencidaException();
		
	}
	public LocalDateTime getDataInicioVigencia() {
		return dataInicioVigencia;
	}
	
}
