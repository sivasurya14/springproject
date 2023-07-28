package com.application.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PercentageException.class)
	public ResponseEntity<Object> percentageException(PercentageException per) {
		return new ResponseEntity<Object>(per.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
