package com.example.demo.controller;


//import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.pojo.Livre;
import com.example.demo.service.LivreService;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class LivreController {

    @Autowired
    LivreService annuaire;

    @GetMapping("livres")
    public List<Livre> getAllLivres(){
        return annuaire.getLivres();
    }

    @PostMapping("livres")
    public void postLivre(@RequestBody Livre livre){
        annuaire.addLivre(livre);
    }

    @DeleteMapping("livres/{id}")
    public void deleteLivre(@PathVariable("id") Integer id){
            annuaire.deleteLivre(id);
    }
    
    @GetMapping("livres/{id}")
    public ResponseEntity<Livre> getLivre(@PathVariable("id") Integer id){
        Optional<Livre> optional = annuaire.getLivre(id);

        if(optional.isPresent()){
        	Livre livre = optional.get();
            return ResponseEntity.ok(livre);
        }
        else {//if(optional.isEmpty())
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("livres/{id}")
    public ResponseEntity putLivre(@PathVariable("id") Integer id, @RequestBody Livre livre){

        if(!id.equals(livre.getId())){
            return ResponseEntity.badRequest().build();
        }

        if(annuaire.getLivre(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        annuaire.editLivre(id, livre);
        return ResponseEntity.ok().build();
    }
}
