package com.mortgage.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.mortgage.domain.exceptions.BusinessException;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(value = { BusinessException.class })
	protected ResponseEntity<Object> handleBusinessException(BusinessException ex, WebRequest request) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
	}

}
