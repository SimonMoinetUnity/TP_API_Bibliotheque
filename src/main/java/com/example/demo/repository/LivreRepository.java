package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Livre;


@Repository
public interface LivreRepository extends JpaRepository<Livre, Integer> {
	
	
	
}
