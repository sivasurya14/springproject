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

import com.myapp.vehicle.Entity.BikeEntity;
import com.myapp.vehicle.Repo.BikeRepo;
import com.myapp.vehicle.Service.BikeService;
import com.myapp.vehicle.exceptionhandler.PriceAndColorNotFoundException;
import com.myapp.vehicle.exceptionhandler.VehicleNotFoundException;

@RestController
@RequestMapping("/bike")
public class BikeController {
	
	@Autowired
	BikeService bikeser;
	BikeRepo bikerepo;
	
	@PostMapping("/saveBikeDetails")
	public String saveBikeDetails(@RequestBody List<BikeEntity> be) {		
		return bikeser.saveBikeDetails(be); 
	}
    @GetMapping("/getBikeDetails")  
    public List<BikeEntity>  getcarDetails(){
    	return bikeser.getCardetails();
    }

    @GetMapping("/findOneBike/{id}")
    public BikeEntity getOneBike(@PathVariable int id) throws VehicleNotFoundException, Exception {
    	return bikeser.findOneBike(id);
    }
    
    @DeleteMapping("deleteBikeById/{id}")
    public String deleteBikeById(@PathVariable int id) throws VehicleNotFoundException, Exception {
    	return bikeser.deleteBikeByID(id);
    }
    
    @PutMapping("/updateBikeDetails/{id}")
    public  String updateBikeDetails( @PathVariable (value="id")int id,@RequestBody BikeEntity be) throws VehicleNotFoundException, Exception{
    	return bikeser.updatBikeDetails(be);
    }
   
    @PutMapping("/update/{id}")
    
    public String UpdateById(@RequestBody BikeEntity e , @PathVariable int id) {
    	bikerepo.save(e);  
    	return "Data Saved successfully";
    }
    
    
    @GetMapping("/getBikeByColor/{name}")
    public List<BikeEntity> getBikeByColor(@PathVariable String name) throws VehicleNotFoundException, Exception{   	
    	return bikeser.getBikeByColor(name);
    	
    }
    
    
    @GetMapping("/getBikeByPriceAndColor/{price}/{color}")
    public List<BikeEntity> getBikeByPriceAndColor(@PathVariable int price ,String color) throws PriceAndColorNotFoundException, Exception{
    	return bikeser.getBikeByPriceAndColor(price, color);
    }
}
