package com.example.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=NameNoFoundException.class)	
	public ResponseEntity<Object> nameNotExceptionHandling(NameNoFoundException ne){
	return new ResponseEntity<Object>(ne.getMessage(), HttpStatus.NOT_FOUND);
	}

}
