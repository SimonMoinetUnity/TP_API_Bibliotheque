package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Auteur;


@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Integer> {
	
	
	
	
}
