package com.nff.insideWorks.insideworksexercise4.service.exception;

public class CustomException extends RuntimeException {
	
private static final long serialVersionUID = 1L;
	
	public CustomException(String placa) {
		super("Não é possível inserir outro veículo com a mesma placa " + placa);
	}

}
