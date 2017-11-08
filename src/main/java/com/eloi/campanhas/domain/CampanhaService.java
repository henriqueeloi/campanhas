package com.eloi.campanhas.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		
		List<Campanha> campanhasPorDataVigencia = getCampanhasPorDataVigencia(campanha);		
		while (!campanhasPorDataVigencia.isEmpty()) {
			for (Campanha atual : campanhasPorDataVigencia) {
				atual.AddUmDiaDataFinalVigencia();
				campanhaRepository.save(atual);
				campanhasPorDataVigencia = getCampanhasPorDataVigencia(atual).stream().filter(c -> c.getId() != atual.getId()).collect(Collectors.toList());
			}						
		}
		
		return campanhaRepository.save(campanha);		
	}

	private List<Campanha> getCampanhasPorDataVigencia(Campanha campanha) {
		List<Campanha> vigencias = campanhaRepository.findByDataInicioVigenciaAndDataFimVigencia(campanha.getDataInicioVigencia(), campanha.getDataFimVigencia());
		return vigencias;
	}

	private Optional<Clube> getClube(Campanha campanha) {		
		Optional<Long> id = campanha.getTimeCoracao().existId();
		if(!id.isPresent())
			return Optional.of(campanha.getTimeCoracao());
			
		return Optional.of(clubeRepository.getOne(id.get()));
	}

	public Campanha getCampanha(Long id) {
		Campanha campanha = campanhaRepository.getOne(id);
		
		campanha.validaDataVigente();
		
		return campanha;
	}
	
}
