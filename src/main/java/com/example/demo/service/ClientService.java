package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Order;
import com.example.demo.pojo.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private int nextId = 0;

   // private List<Categorie> soigneurs = new ArrayList<>();
    
    @Autowired
	ClientRepository repo;

    public void addClient(Client client){
        nextId++;
        client.setId(nextId);
        repo.save(client);
    }

    public List<Client> getClients(){
    	return repo.findAll();
   }
    
    public Optional<Client> getClient(Integer id){
    	return repo.findById(id);
    }
    
    public void deleteClient(int id){
    	repo.deleteById(id);
    }

    public void editClient(Integer id, Client client) {
    	repo.save(client);
    }
}
