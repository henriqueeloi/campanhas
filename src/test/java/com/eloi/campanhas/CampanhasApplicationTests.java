package com.eloi.campanhas;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.eloi.campanhas.domain.Campanha;
import com.eloi.campanhas.domain.CampanhaService;
import com.eloi.campanhas.domain.Clube;
import com.eloi.campanhas.infrastructure.exception.DataVigenciaVencidaException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CampanhasApplication.class})
public class CampanhasApplicationTests {

	
	@Autowired
	private CampanhaService service;
	
	@Test
	public void contextLoads() {
	}
	
	@Test(expected = DataVigenciaVencidaException.class)
	public void deveValidarVigenciaDaCampanha(){
		
		String nome = "Poderoso Timão";
		Clube timeCoracao = new Clube("Sport Club Corinthians Paulista");
		LocalDateTime dataVigencia = LocalDateTime.now();
		Campanha campanha = new Campanha(nome, timeCoracao, dataVigencia);
		
		service.save(campanha);		
		
	}

}
