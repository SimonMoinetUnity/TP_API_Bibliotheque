package com.example.demo.controller;


//import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.pojo.Client;
import com.example.demo.service.ClientService;
import com.example.demo.service.OrderService;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    @Autowired
    ClientService annuaire;

    @GetMapping("clients")
    public List<Client> getAllClients(){
        return annuaire.getClients();
    }

    @PostMapping("clients")
    public void postCategorie(@RequestBody Client client){
        annuaire.addClient(client);
    }

    @DeleteMapping("clients/{id}")
    public void deleteCategorie(@PathVariable("id") Integer id){
            annuaire.deleteClient(id);
    }
    
    @GetMapping("clients/{id}")
    public ResponseEntity<Client> getCategorie(@PathVariable("id") Integer id){
        Optional<Client> optional = annuaire.getClient(id);

        if(optional.isPresent()){
        	Client client = optional.get();
            return ResponseEntity.ok(client);
        }
        else {//if(optional.isEmpty())
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("clients/{id}")
    public ResponseEntity putCategorie(@PathVariable("id") Integer id, @RequestBody Client client){

        if(!id.equals(client.getId())){
            return ResponseEntity.badRequest().build();
        }

        if(annuaire.getClient(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        annuaire.editClient(id, client);
        return ResponseEntity.ok().build();
    }
}
