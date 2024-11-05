package com.mortgage.domain.exceptions;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 6040510464579157653L;

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
	}
}
