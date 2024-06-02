package com.app.custom_exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public String handleException(ResourceNotFoundException ex) {
		
		return ex.getMessage();
	}
	
}
