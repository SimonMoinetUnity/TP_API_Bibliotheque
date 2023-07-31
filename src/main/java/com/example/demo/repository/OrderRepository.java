package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Client;
import com.example.demo.pojo.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	
	
}
