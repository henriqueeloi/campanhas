package com.eloi.campanhas.infrastructure.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvise {
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(EntityNotFoundException.class)
	public VndErrors handleEntityNotFound(EntityNotFoundException ex) {
		String message = ex.getMessage();
		return getVndError(message);
	}
			
	@ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    VndErrors testNotFoundExceptionHandler(NotFoundException ex) {
		String message = ex.getMessage();
		return getVndError(message);
		
		
    }

	private VndErrors getVndError(String message) {
		return new VndErrors(
				"Error",
				message,
				new Link("http://...", "about")                
				);
	}
	
}
