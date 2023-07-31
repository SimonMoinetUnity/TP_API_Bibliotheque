package com.example.demo.controller;


//import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.pojo.Client;
import com.example.demo.pojo.Order;
import com.example.demo.service.OrderService;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    OrderService annuaire;

    @GetMapping("orders")
    public List<Order> getAllOrders(){
        return annuaire.getOrders();
    }

    @PostMapping("orders")
    public void postOrder(@RequestBody Order order){
        annuaire.addOrder(order);
    }

    @DeleteMapping("orders/{id}")
    public void deleteOrder(@PathVariable("id") Integer id){
            annuaire.deleteOrder(id);
    }
    
    @GetMapping("orders/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") Integer id){
        Optional<Order> optional = annuaire.getOrder(id);

        if(optional.isPresent()){
        	Order order = optional.get();
            return ResponseEntity.ok(order);
        }
        else {//if(optional.isEmpty())
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("orders/{id}")
    public ResponseEntity putOrder(@PathVariable("id") Integer id, @RequestBody Order order){

        if(!id.equals(order.getId())){
            return ResponseEntity.badRequest().build();
        }

        if(annuaire.getOrder(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        annuaire.editOrder(id, order);
        return ResponseEntity.ok().build();
    }
}
