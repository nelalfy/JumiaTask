package com.jumia.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jumia.task.entity.Customer;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	
}
