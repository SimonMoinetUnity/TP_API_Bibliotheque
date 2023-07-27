package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Auteur;
import com.example.demo.pojo.Categorie;
import com.example.demo.pojo.Livre;
import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.LivreRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    private int nextId = 0;

   // private List<Categorie> soigneurs = new ArrayList<>();
    
    @Autowired
	CategorieRepository repo;

    public void addCategorie(Categorie categorie){
        nextId++;
        categorie.setId(nextId);
        repo.save(categorie);
    }

    public List<Categorie> getCategories(){
    	return repo.findAll();
   }
    
    public Optional<Categorie> getCategorie(Integer id){
    	return repo.findById(id);
    }
    
    public void deleteCategorie(int id){
    	repo.deleteById(id);
    }

    public void editCategorie(Integer id, Categorie categorie) {
    	repo.save(categorie);
    }
}
