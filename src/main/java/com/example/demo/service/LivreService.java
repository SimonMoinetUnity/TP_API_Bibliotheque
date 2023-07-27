package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Auteur;
import com.example.demo.pojo.Livre;
import com.example.demo.repository.LivreRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LivreService {

    private int nextId = 0;

    //private List<Livre> tigres = new ArrayList<>();
    
    @Autowired
	LivreRepository repo;

    public void addLivre(Livre livre){
        nextId++;
        livre.setId(nextId);
        repo.save(livre);
    }

    public List<Livre> getLivres(){
    	return repo.findAll();
   }
    
    public Optional<Livre> getLivre(Integer id){
    	return repo.findById(id);
    }
    
    public void deleteLivre(int id){
    	repo.deleteById(id);
    }

    public void editLivre(Integer id, Livre livre) {
    	repo.save(livre);
    }
}
