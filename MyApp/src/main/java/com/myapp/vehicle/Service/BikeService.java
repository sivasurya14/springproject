package com.myapp.vehicle.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.vehicle.Dao.BikeDao;
import com.myapp.vehicle.Entity.BikeEntity;
import com.myapp.vehicle.Repo.BikeRepo;
import com.myapp.vehicle.exceptionhandler.PriceAndColorNotFoundException;
import com.myapp.vehicle.exceptionhandler.VehicleNotFoundException;

@Service
public class BikeService {

	@Autowired
	BikeDao bikedao;
	@Autowired
	BikeRepo bikerepo;

	public String saveBikeDetails(List<BikeEntity> be) {
		return bikedao.saveBikeDetails(be);
	}

	public List<BikeEntity> getCardetails() {
		return bikedao.getBikeDetails();
	}

	public BikeEntity findOneBike(int id) throws VehicleNotFoundException, Exception {
		return bikedao.findOneBike(id);
	}

	public String deleteBikeByID(int id) throws VehicleNotFoundException, Exception {

		if (bikerepo.existsById(id)) {
			bikerepo.deleteById(id);
		} else {
			throw new VehicleNotFoundException(
					"The Id you are trying to delete is not avalaible in database..! check Again.");
		}
		return "Id is successfully deleted ";
	}

	public String updatBikeDetails(BikeEntity be) throws VehicleNotFoundException, Exception {
		if (bikedao.updateBikeDetails(be).isEmpty()) {

			throw new VehicleNotFoundException(
					"The vehicle you are trying to UPDATE is not available in database.! Check Again. ");
		} else {
			return bikedao.updateBikeDetails(be);
		}
	}

	public List<BikeEntity> getBikeByColor(String name) throws VehicleNotFoundException, Exception {

		if (bikedao.getBikeByColor(name).isEmpty()) {
			throw new VehicleNotFoundException("vehicle is not available..!");
		} else {
			return bikedao.getBikeByColor(name);
		}
	}
	
    public List<BikeEntity> getBikeByPriceAndColor(int price , String color) throws PriceAndColorNotFoundException, Exception{
    	
    	if(bikedao.getBikeByPriceAndColor(price, color).isEmpty()) {
    		throw new PriceAndColorNotFoundException("There is no vehicel....");		
    	}else {    		
    		return bikedao.getBikeByPriceAndColor(price, color);
    	}
    	
    }
}
