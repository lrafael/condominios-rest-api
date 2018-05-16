package com.condominios.api.service.exception;

public class RecursoInexistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String errorMessage;

	public RecursoInexistenteException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return errorMessage.toString();
	}

}
