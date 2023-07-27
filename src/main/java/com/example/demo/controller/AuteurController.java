package com.example.demo.controller;


//import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.pojo.Auteur;
import com.example.demo.service.AuteurService;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class AuteurController {

    @Autowired
    AuteurService annuaire;

    @GetMapping("auteurs")
    public List<Auteur> getAllAuteurs(){
        return annuaire.getAuteurs();
    }

    @PostMapping("auteurs")
    public void postAuteur(@RequestBody Auteur auteur){
        annuaire.addAuteur(auteur);
    }

    @DeleteMapping("auteurs/{id}")
    public void deleteAuteur(@PathVariable("id") Integer id){
            annuaire.deleteAuteur(id);
    }
    
    @GetMapping("auteurs/{id}")
    public ResponseEntity<Auteur> getAuteur(@PathVariable("id") Integer id){
        Optional<Auteur> optional = annuaire.getAuteur(id);

        if(optional.isPresent()){
        	Auteur auteur = optional.get();
            return ResponseEntity.ok(auteur);
        }
        else {//if(optional.isEmpty())
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("auteurs/{id}")
    public ResponseEntity putAuteur(@PathVariable("id") Integer id, @RequestBody Auteur auteur){

        if(!id.equals(auteur.getId())){
            return ResponseEntity.badRequest().build();
        }

        if(annuaire.getAuteur(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        annuaire.editAuteur(id, auteur);
        return ResponseEntity.ok().build();
    }
}
