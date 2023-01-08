package com.gerenciador.pessoas.main.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gerenciador.pessoas.main.services.exceptions.ResourceNotFoundException;
import com.gerenciador.pessoas.main.services.exceptions.ResourceUnprocessableException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err); 
	}
	
	@ExceptionHandler(ResourceUnprocessableException.class)
	public ResponseEntity<StandardError> resourceUnprocessable(ResourceUnprocessableException e, HttpServletRequest request){
		String error = "Resource Unprocessable Entity";
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err); 
	}
}
