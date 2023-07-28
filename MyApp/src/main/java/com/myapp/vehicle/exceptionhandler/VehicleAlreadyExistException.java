package com.myapp.vehicle.exceptionhandler;

public class VehicleAlreadyExistException extends Exception {

	public VehicleAlreadyExistException(String message) {
		super(message);
	}
}
