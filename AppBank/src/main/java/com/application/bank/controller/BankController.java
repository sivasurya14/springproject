package com.application.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.bank.entity.BanKEntity;
import com.application.bank.service.BankService;

@RestController
public class BankController {
	
	@Autowired
	BankService bankService;
	
	@PostMapping("/saveBankInfo")
	public String saveBankInfo(@RequestBody List<BanKEntity> var) {
		return bankService.saveBankInfo(var);
	}

	@GetMapping("/getIfscCode/{name}")
	public String getIfscCode(@PathVariable String name) {
		return bankService.getIfscCode(name);
	}
	
}
