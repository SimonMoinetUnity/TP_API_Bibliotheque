package com.example.demo.controller;


//import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.pojo.Categorie;
import com.example.demo.pojo.Livre;
import com.example.demo.service.CategorieService;
import com.example.demo.service.LivreService;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class CategorieController {

    @Autowired
    CategorieService annuaire;

    @GetMapping("categories")
    public List<Categorie> getAllSoigneurs(){
        return annuaire.getCategories();
    }

    @PostMapping("categories")
    public void postCategorie(@RequestBody Categorie categorie){
        annuaire.addCategorie(categorie);
    }

    @DeleteMapping("categories/{id}")
    public void deleteCategorie(@PathVariable("id") Integer id){
            annuaire.deleteCategorie(id);
    }
    
    @GetMapping("categories/{id}")
    public ResponseEntity<Categorie> getCategorie(@PathVariable("id") Integer id){
        Optional<Categorie> optional = annuaire.getCategorie(id);

        if(optional.isPresent()){
        	Categorie categorie = optional.get();
            return ResponseEntity.ok(categorie);
        }
        else {//if(optional.isEmpty())
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("categories/{id}")
    public ResponseEntity putCategorie(@PathVariable("id") Integer id, @RequestBody Categorie categorie){

        if(!id.equals(categorie.getId())){
            return ResponseEntity.badRequest().build();
        }

        if(annuaire.getCategorie(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        annuaire.editCategorie(id, categorie);
        return ResponseEntity.ok().build();
    }
}
