package com.myapp.vehicle.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.vehicle.Entity.BikeEntity;
import com.myapp.vehicle.Repo.BikeRepo;
import com.myapp.vehicle.exceptionhandler.PriceAndColorNotFoundException;
import com.myapp.vehicle.exceptionhandler.VehicleNotFoundException;

@Repository
public class BikeDao {
	
	@Autowired
	BikeRepo bikerepo;
	
	public String saveBikeDetails(List<BikeEntity> be) {
	bikerepo.saveAll(be);	
	return "Data Saved successfully";
		
	}
   public List<BikeEntity>  getBikeDetails(){   
	   return bikerepo.findAll();
   }
   public BikeEntity  findOneBike(int id) throws VehicleNotFoundException, Exception {   
	   BikeEntity bikeentity;
		if(bikerepo.findById(id).isEmpty()) {
			throw new VehicleNotFoundException("vehicle id is not Available : ");			
		} else {
			bikeentity =bikerepo.findById(id).get();
		}	   
	   return bikeentity;
   } 
   public String deleteBikeById(int id) throws VehicleNotFoundException, Exception{	  
	      bikerepo.deleteById(id);
	    return "Data deleted successfully";
   } 
   public String updateBikeDetails(BikeEntity be) throws VehicleNotFoundException, Exception {
	   bikerepo.save(be);
	   return "Data Updated successfully";
   }
  
   public List<BikeEntity>  getBikeByColor(String name )throws VehicleNotFoundException, Exception{
	   return bikerepo.getBikeByColor(name);
   }
   
   public List<BikeEntity>  getBikeByPriceAndColor(int price, String color) throws PriceAndColorNotFoundException, Exception{
	   return bikerepo.getBikeByPriceAndColor(price, color);
   }
   
}
