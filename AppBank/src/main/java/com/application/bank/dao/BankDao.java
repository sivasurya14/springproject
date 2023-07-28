package com.application.bank.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.bank.entity.BanKEntity;
import com.application.bank.repo.BankRepo;

@Repository
public class BankDao {
	
	@Autowired
	BankRepo bankRepo;
	
	public String saveBankInfo(List<BanKEntity> var) {
		bankRepo.saveAll(var);
		return "Data Saved successfully";		
	}
	
	public String getIfscCode(String name) {
		return bankRepo.getIfscCode(name);
	}


}
