package com.example.demo.pojo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "livre")
public class Livre {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    private String titre;
    private Integer nombreDePage;
    
    @ManyToOne
    private Auteur auteur;
    
    @ManyToMany
    private List<Categorie> categories = new ArrayList<>();

    public Livre() {
    }
    
    

	public Livre(int id, String titre, Integer nombreDePage, Auteur auteur, List<Categorie> categories) {
		super();
		this.id = id;
		this.titre = titre;
		this.nombreDePage = nombreDePage;
		this.auteur = auteur;
		this.categories = categories;
	}

	
    public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}



	public Integer getNombreDePage() {
		return nombreDePage;
	}



	public void setNombreDePage(Integer nombreDePage) {
		this.nombreDePage = nombreDePage;
	}



	public Auteur getAuteur() {
		return auteur;
	}



	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}



	public List<Categorie> getCategories() {
		return categories;
	}



	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}



	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", nombreDePage=" + nombreDePage + ", auteur=" + auteur
				+ ", categories=" + categories + "]";
	}



	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
