package com.example.start.Dto;

import jakarta.persistence.Column;

public class FournisseurRequest {
    private String nomFournisseur;
    private String tel;
    private String email;

    public FournisseurRequest() {
    }

    public FournisseurRequest(String nomFournisseur, String tel, String email) {
        this.nomFournisseur = nomFournisseur;
        this.tel = tel;
        this.email = email;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

