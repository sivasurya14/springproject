package com.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transaction.entity.Sender;

public interface SenderRepo extends JpaRepository<Sender, Integer>{

}
