package com.eloi.campanhas.domain;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampanhaService {

	@Autowired
	private ClubeRepository clubeRepository;
	
	@Autowired
	private CampanhaRepository campanhaRepository;
	
	public Campanha save(Campanha campanha){
		
		Optional<Clube> clube = getClube(campanha);
		campanha.defineClube(clube.get());
		
		return campanhaRepository.save(campanha);		
	}

	private Optional<Clube> getClube(Campanha campanha) {		
		Optional<Long> id = campanha.getTimeCoracao().existId();
		if(!id.isPresent())
			return Optional.of(campanha.getTimeCoracao());
			
		return Optional.of(clubeRepository.getOne(id.get()));
	}
	
}
