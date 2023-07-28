package com.application.custm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.custm.entity.CustomerEntity;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {

}
