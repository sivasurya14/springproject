package com.application.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.bank.dao.BankDao;
import com.application.bank.entity.BanKEntity;

@Service
public class BankService {
	@Autowired
	BankDao bankDao;
	
	public String saveBankInfo(List<BanKEntity> var) {	
		return bankDao.saveBankInfo(var);
	}

	public String getIfscCode(String name) {
		return bankDao.getIfscCode(name);
	}
}
