package com.example.start.entities;

import com.example.start.enums.Etat;
import com.example.start.user.UserEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class CatArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String categorie;

    @Column(nullable = false)
    private Etat etatCat;
    //@JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "catArticle", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Collection<Article> articles = new ArrayList<>();

    //Constructors
    public CatArticle() {
    }

    public CatArticle(Long id, String categorie, Etat etatCat, Collection<Article> articles) {
        this.id = id;
        this.categorie = categorie;
        this.etatCat = etatCat;
        this.articles = articles;
    }

    //Get and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Etat getEtatCat() {
        return etatCat;
    }

    public void setEtatCat(Etat etatCat) {
        this.etatCat = etatCat;
    }

    public Collection<Article> getArticles() {
        return articles;
    }

    public void setArticles(Collection<Article> articles) {
        this.articles = articles;
    }
}
