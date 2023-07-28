package com.myapp.vehicle.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptioHandler {
	
	@ExceptionHandler(value=VehicleNotFoundException.class)
	public ResponseEntity<Object> vehicleNotFounHandling(VehicleNotFoundException ref){		
		return  new ResponseEntity<>(ref.getMessage(), HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(value=PriceAndColorNotFoundException.class)
	public ResponseEntity<Object> priceAndColorNotFound(PriceAndColorNotFoundException PriceAndColor){
	return new ResponseEntity<Object>(PriceAndColor.getMessage(), HttpStatus.NOT_FOUND);	
				
	}		
	}


