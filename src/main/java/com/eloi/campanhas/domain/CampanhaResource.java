package com.eloi.campanhas.domain;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CampanhaResource extends ResourceSupport {

	final private Campanha content;
	
	@JsonCreator
	public CampanhaResource(@JsonProperty("content") Campanha content) {
		this.content = content;		
	}
	
	public Campanha getContent(){
		return content;
	}
	
}
