package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Order;
import com.example.demo.pojo.Client;
import com.example.demo.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private int nextId = 0;

    //private List<Livre> tigres = new ArrayList<>();
    
    @Autowired
	OrderRepository repo;

    public void addOrder(Order order){
        nextId++;
        order.setId(nextId);
        repo.save(order);
    }

    public List<Order> getOrders(){
    	return repo.findAll();
   }
    
    public Optional<Order> getOrder(Integer id){
    	return repo.findById(id);
    }
    
    public void deleteOrder(int id){
    	repo.deleteById(id);
    }

    public void editOrder(Integer id, Order order) {
    	repo.save(order);
    }
}
