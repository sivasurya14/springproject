package com.myapp.vehicle.exceptionhandler;


public class VehicleNotFoundException extends RuntimeException {

	
	public VehicleNotFoundException(String message) {
		super(message);
	}
}
