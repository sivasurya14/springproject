package com.myapp.vehicle.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myapp.vehicle.Dao.CarDao;
import com.myapp.vehicle.Entity.CarEntity;
import com.myapp.vehicle.exceptionhandler.VehicleNotFoundException;

@Service
public class CarService {
	
	@Autowired
	CarDao carDao;
	public String addCarDetails(List<CarEntity> e) {	
		return carDao.addCarDetails(e);
	}
	
	public List<CarEntity>  getCarDetails(){	
		return carDao.getCarDetails();
	}
	
	public String updateCarDetails(CarEntity e) {	
		return carDao.updateCarDetails(e);
	}
	
	public CarEntity  findCarById(int id) throws VehicleNotFoundException, Exception {
		
			return carDao.getCarById(id);
	}
	
	public  List<CarEntity> deleteByid(int id)throws VehicleNotFoundException , Exception {			
		if(carDao.deleteById(id).isEmpty()) {
			throw new VehicleNotFoundException("The Vehicle you are trying to delete is not present..!");
		}
		else {
		carDao.deleteById(id);
		List<CarEntity> list=carDao.getCarDetails();
		return list;
		}
	}
}
