package com.myapp.vehicle.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.vehicle.Entity.CarEntity;



public interface CarRepo extends JpaRepository<CarEntity, Integer> {

}
