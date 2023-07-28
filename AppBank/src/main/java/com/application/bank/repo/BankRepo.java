package com.application.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.application.bank.entity.BanKEntity;

public interface BankRepo extends JpaRepository<BanKEntity, Integer>{
	
	
	@Query(value="select ifsc_code from bank_table where branch =?",nativeQuery = true)
	public String getIfscCode(String name);
	
}

