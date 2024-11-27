package com.example.start.controllers;

import com.example.start.Dto.FournisseurRequest;
import com.example.start.entities.CatArticle;
import com.example.start.entities.Fournisseur;
import com.example.start.enums.Etat;
import com.example.start.services.CartArticleService;
import com.example.start.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "fournisseur")
public class FournisseurController {
    @Autowired
    private FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    //public void creer(@RequestBody Fournisseur fournisseur){
    public void creer(@RequestBody FournisseurRequest fournisseur){
        Fournisseur Four = new Fournisseur();
        Four.setNomFournisseur(fournisseur.getNomFournisseur());
        Four.setEmail(fournisseur.getEmail());
        Four.setTel(fournisseur.getTel());
        Four.setEtatFournisseur(Etat.VALIDE);
        this.fournisseurService.creer(Four);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Fournisseur> recherher(){
        return this.fournisseurService.recherche();
    }

    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    public Fournisseur fournisseur(@PathVariable int id){
        return this.fournisseurService.lire(id);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    //public void update(@PathVariable int id, @RequestBody Fournisseur fournisseur){
    public void update(@PathVariable int id, @RequestBody FournisseurRequest fournisseur){
        Fournisseur Four = new Fournisseur();
        Four.setNomFournisseur(fournisseur.getNomFournisseur());
        Four.setEmail(fournisseur.getEmail());
        Four.setTel(fournisseur.getTel());
        Four.setEtatFournisseur(Etat.VALIDE);

        this.fournisseurService.modifier(id,Four);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "/delete/{id}")
    public void updateEtat(@PathVariable long id){
        this.fournisseurService.updateEtatFourById(id);
    }
}
