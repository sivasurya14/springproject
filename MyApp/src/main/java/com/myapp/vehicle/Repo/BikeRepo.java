package com.myapp.vehicle.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myapp.vehicle.Entity.BikeEntity;


public interface BikeRepo extends JpaRepository<BikeEntity, Integer> {

	
 @Query(value="select * from bike_tabel where color=?",nativeQuery = true )
 public List<BikeEntity>  getBikeByColor(String name);
	
 @Query(value="select * from bike_tabel where price>? and color =?", nativeQuery = true)
 public List<BikeEntity> getBikeByPriceAndColor (int price , String color);

}
