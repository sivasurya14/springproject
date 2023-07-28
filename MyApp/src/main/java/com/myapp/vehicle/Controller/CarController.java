package com.myapp.vehicle.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.vehicle.Entity.CarEntity;
import com.myapp.vehicle.Service.CarService;
import com.myapp.vehicle.exceptionhandler.VehicleNotFoundException;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	CarService carser;
	@PostMapping("/saveCarDetails")
	public String addCarDetails(@RequestBody List<CarEntity> e) {	
		return carser.addCarDetails(e);
	}
	
	@GetMapping("/getCarDetails")
	public List<CarEntity> getCarDetails() {		
		return carser.getCarDetails();		
	}
	
	@PutMapping("/updateCar/{e}")
	public String  updateCarDetails(@RequestBody CarEntity e ) {
		return carser.updateCarDetails(e);		
	}
	
	@GetMapping("/getById")
	public CarEntity  getCarById(@PathVariable int id ) throws VehicleNotFoundException, Exception {
		return carser.findCarById(id);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public List<CarEntity> deleteCarByid(@PathVariable int id) throws VehicleNotFoundException, Exception {
		 carser.deleteByid(id);
		 List<CarEntity> list =carser.getCarDetails();
		return list;
	}
}
