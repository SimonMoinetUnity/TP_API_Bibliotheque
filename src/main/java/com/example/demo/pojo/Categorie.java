package com.example.demo.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorie")
public class Categorie {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    private String ageLimite;
    private String nom;

    public Categorie() {
    }
    public Categorie(String ageLimite, String nom) {
        this.ageLimite = ageLimite;
        this.nom = nom;
    }

    public String getAgeLimite() {
		return ageLimite;
	}
	public void setAgeLimite(String ageLimite) {
		this.ageLimite = ageLimite;
	}
	public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    @Override
	public String toString() {
		return "Categorie [id=" + id + ", ageLimite=" + ageLimite + ", nom=" + nom + "]";
	}
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
