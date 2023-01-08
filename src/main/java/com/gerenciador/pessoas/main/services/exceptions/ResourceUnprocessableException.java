package com.gerenciador.pessoas.main.services.exceptions;

public class ResourceUnprocessableException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ResourceUnprocessableException(String message) {
		super(message);
	}
}
