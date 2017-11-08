package com.eloi.campanhas.domain;

import java.time.LocalDate;

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
	
	private LocalDate dataInicioVigencia;
	
	private LocalDate dataFimVigencia;

	public Campanha(String nome, Clube timeCoracao, LocalDate dataInicioVigencia2, LocalDate dataFimVigencia2) {
		super();
		this.nome = nome;
		this.timeCoracao = timeCoracao;
		this.dataInicioVigencia = dataInicioVigencia2;
		this.dataFimVigencia = dataFimVigencia2;
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

	public LocalDate getDataVigencia() {
		return dataInicioVigencia;
	}
	public void defineClube(Clube clube) {
		this.timeCoracao = clube;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDataFimVigencia() {
		return dataFimVigencia;
	}

	public LocalDate getDataInicioVigencia() {
		return dataInicioVigencia;
	}

	public void validaDataVigente() {
		if(LocalDate.now().isAfter(this.getDataFimVigencia()))
			throw new DataVigenciaVencidaException();	
	}
	
	public void AddUmDiaDataFinalVigencia(){
		this.dataFimVigencia = this.dataFimVigencia.plusDays(1);
	}
	
}
