package com.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.entity.Sender;
import com.transaction.entity.TranscationClass;
import com.transaction.repository.ReccieverRepo;
import com.transaction.repository.SenderRepo;

import jakarta.transaction.Transactional;

@RestController
public class TransactionController {

	@Autowired
	SenderRepo senderRepo;

	@Autowired
	ReccieverRepo recieverRepo;

	@PostMapping("/saveTranscation")
    @Transactional
	public String saveTransaction(@RequestBody TranscationClass trans) {

		senderRepo.save(trans.getSender());

		// System.out.println(e.getMessage());

		recieverRepo.save(trans.getReciever());

		return "saved successfully";
	}

}
