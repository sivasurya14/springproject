package com.myapp.vehicle.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.vehicle.Entity.CarEntity;
import com.myapp.vehicle.Repo.CarRepo;
import com.myapp.vehicle.exceptionhandler.VehicleNotFoundException;

@Repository
public class CarDao {

	@Autowired
	CarRepo carRepo;
    public String addCarDetails(List<CarEntity> e) {
    	carRepo.saveAll(e);   	
    	return "saved data successfully";
    }
    
    public List<CarEntity>  getCarDetails(){   	
    	return carRepo.findAll();
    }
    
    public String updateCarDetails(CarEntity e) {
    	carRepo.save(e); 	
    	return "updated data successfully";
    }
    
    public CarEntity getCarById(int id)throws VehicleNotFoundException, Exception {  
    	if(carRepo.findById(id).isEmpty()) {
    		throw new VehicleNotFoundException("Vehicle is not present...");
    	}
    	else {
    	return carRepo.findById(id).get();
    }
    }
    public List<CarEntity> deleteById(int id) throws VehicleNotFoundException, Exception {  	
    	carRepo.deleteById(id);   	
    	 List<CarEntity> list =carRepo.findAll();
        return list;
   	
    }
    
}
