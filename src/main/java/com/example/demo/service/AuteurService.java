package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Auteur;
import com.example.demo.repository.AuteurRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuteurService {

    private int nextId = 0;

   // private List<Auteur> auteurs = new ArrayList<>();
    
    @Autowired
	AuteurRepository repo;

    public void addAuteur(Auteur auteur){
        nextId++;
        auteur.setId(nextId);
        repo.save(auteur);
    }

    public List<Auteur> getAuteurs(){
    	return repo.findAll();
   }
    
    public Optional<Auteur> getAuteur(Integer id){
    	return repo.findById(id);
    }
    
    public void deleteAuteur(int id){
    	repo.deleteById(id);
    }

    public void editAuteur(Integer id, Auteur auteur) {
    	repo.save(auteur);
    }
}
