package com.example.start.services;

import com.example.start.entities.Article;
import com.example.start.entities.CatArticle;
import com.example.start.entities.Fournisseur;
import com.example.start.enums.Etat;
import com.example.start.repositories.ArticleRepository;
import com.example.start.repositories.CatArticleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CartArticleService cartArticleService;
    @Autowired
    private FournisseurService fournisseurService;

    public ArticleService(CartArticleService cartArticleService, ArticleRepository articleRepository, FournisseurService fournisseurService) {
        this.cartArticleService = cartArticleService;
        this.articleRepository = articleRepository;
        this.fournisseurService = fournisseurService;
    }

    @Transactional
    //public void creerArticleAvecFournisseur(Article article, Fournisseur fournisseur){
    public void creerArticleAvecFournisseur(Article article, Collection<Fournisseur> fournisseur){
        CatArticle categorieExistBdd = this.cartArticleService.lireOuCreer(article.getCatArticle());
        for(Fournisseur four : fournisseur){
            Fournisseur fournisseurExist = this.fournisseurService.lireOuCreer(four);
            article.getFournisseurs().add(fournisseurExist);
        }
        article.setCatArticle(categorieExistBdd);
        this.articleRepository.save(article);
    }

    @Transactional
    public List<Article> recherche(){
        List<Article> articles;
        articles = articleRepository.findByEtatArticle(Etat.VALIDE);
        if(articles.isEmpty()){
            return new ArrayList<>();
        }
        return articles;
    }

    @Transactional
    public Article lire(long id){
        Optional<Article> optionalArticle;
        /* optionalCategorie = this.catArticleRepository.findById(id); */
        optionalArticle = this.articleRepository.findByIdAndEtatArticle(id, Etat.VALIDE);
        if (optionalArticle.isPresent()){
            return optionalArticle.get();
        }
        return null;
        //return optionalClient.orElse(null);
    }

    @Transactional
    public Article lire2(long id){
        Optional<Article> optionalArticle;
        optionalArticle = this.articleRepository.findById(id);
        if (optionalArticle.isPresent()){
            return optionalArticle.get();
        }
        return null;
        //return optionalClient.orElse(null);
    }

    @Transactional
    public void updateEtatArticletById(Long id) {
        Article article = this.lire(id);
        if(article.getId() != null){
            article.setEtatArticle(Etat.NON_VALIDE);
            Article save = this.articleRepository.save(article);
        }
    }

    @Transactional
    public void modifier(int id, Article article, Collection<Fournisseur> fournisseur) {
        Article articleBdd = this.lire2(id);
        if(null != articleBdd.getId()){
            if(article.getEtatArticle() != null){
                articleBdd.setEtatArticle(article.getEtatArticle());
            }
            if(article.getCatArticle() != null){
                articleBdd.setCatArticle(article.getCatArticle());
            }
            if(article.getNomArticle() != null){
                articleBdd.setNomArticle(article.getNomArticle());
            }
            if(article.getDescription() != null){
                articleBdd.setDescription(article.getDescription());
            }
            if(article.getFournisseurs() != null){
                articleBdd.setFournisseurs(article.getFournisseurs());
            }
            if(article.getDatePeremption() != null){
                articleBdd.setDatePeremption(article.getDatePeremption());
            }
            if(article.getQuantite() != articleBdd.getQuantite()){
                articleBdd.setQuantite(article.getQuantite());
            }
            if(article.getPrixUnit() != articleBdd.getPrixUnit()){
                articleBdd.setPrixUnit(article.getPrixUnit());
            }
            if(article.getReference() != null){
                articleBdd.setReference(article.getReference());
            }
            if(articleBdd.getFournisseurs() != fournisseur) {
                articleBdd.getFournisseurs().clear();
                articleBdd.getFournisseurs().addAll(fournisseur);
            }
            this.articleRepository.save(articleBdd);
        }
    }
}