package com.eloi.campanhas;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.eloi.campanhas.domain.Campanha;
import com.eloi.campanhas.domain.CampanhaRepository;
import com.eloi.campanhas.domain.CampanhaService;
import com.eloi.campanhas.domain.Clube;
import com.eloi.campanhas.infrastructure.exception.DataVigenciaVencidaException;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class CampanhasApplicationTests {

	
	@Autowired
	private CampanhaService service;
		
	@Autowired
	private CampanhaRepository repository;
	
	@Test(expected = DataVigenciaVencidaException.class)
	public void deveValidarVigenciaDaCampanha(){
		
		String nome = "Poderoso Timão";
		Clube timeCoracao = new Clube("Sport Club Corinthians Paulista");
		LocalDateTime dataInicioVigencia = LocalDateTime.of(2017, 11, 1, 11, 59);
		LocalDateTime dataFimVigencia = LocalDateTime.of(2017, 11, 3, 11, 59);
		
		Campanha campanha = new Campanha(nome, timeCoracao, dataInicioVigencia, dataFimVigencia);
		Campanha saved = service.save(campanha);
				
		service.getCampanha(saved.getId());		
	}

	@Test(expected = DataVigenciaVencidaException.class)
	public void deveRetornarCampanhasComMesmaDataDeVigencia(){
		
		String nome = "Campanha 1";
		Clube timeCoracao = new Clube("Sport Club Corinthians Paulista");
		LocalDateTime dataInicioVigencia = LocalDateTime.of(2017, 11, 1, 11, 59);
		LocalDateTime dataFimVigencia = LocalDateTime.of(2017, 11, 20, 11, 59);
		Campanha campanha = new Campanha(nome, timeCoracao, dataInicioVigencia, dataFimVigencia);
		Campanha saved = service.save(campanha);
		
		String nome2 = "Campanha 2";
		Clube timeCoracao2 = new Clube("Sport Club Corinthians Paulista");
		LocalDateTime dataInicioVigencia2 = LocalDateTime.of(2017, 11, 1, 11, 59);
		LocalDateTime dataFimVigencia2 = LocalDateTime.of(2017, 11, 19, 11, 59);		
		Campanha campanha2 = new Campanha(nome2, timeCoracao2, dataInicioVigencia2, dataFimVigencia2);		
		Campanha saved2 = service.save(campanha2);
				
		repository
	}

	
}
