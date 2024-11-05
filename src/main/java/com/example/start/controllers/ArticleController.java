package com.example.start.controllers;

import com.example.start.Dto.ArticleFournisseurRequest;
import com.example.start.entities.Article;
import com.example.start.entities.Fournisseur;
import com.example.start.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/art")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    //public void creer(@RequestBody Article article, @RequestBody Fournisseur fournisseur){
    public void creer(@RequestBody ArticleFournisseurRequest artFour){
        System.out.println("ELEMENT "+artFour);
        //this.articleService.creerArticleAvecFournisseur(article, fournisseur);
        this.articleService.creerArticleAvecFournisseur(artFour.getArticle(),artFour.getFournisseur());
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Article> recherher(){
        return this.articleService.recherche();
    }

    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    public Article article(@PathVariable int id){
        return this.articleService.lire(id);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void update(@PathVariable int id, @RequestBody ArticleFournisseurRequest artFour){
        this.articleService.modifier(id,artFour.getArticle(), artFour.getFournisseur());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "/delete/{id}")
    public void updateEtat(@PathVariable long id){
        this.articleService.updateEtatArticletById(id);
    }
}
