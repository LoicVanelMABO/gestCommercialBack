package com.example.start.entities;

import com.example.start.enums.Etat;
import com.example.start.enums.EtatObjetTicket;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String num;

    @Column(nullable = false)
    private Date openDate;

    @Column(nullable = true)
    private Date closeDate;

    @Column(nullable = false)
    private EtatObjetTicket Objet;

    @Column(nullable = false)
    private String initUser;

    @Column(nullable = false)
    private String nextUser;

    @Column(nullable = true)
    private String nextRole;

    @Column(nullable = false)
    private String motifs;

    @Column(nullable = true)
    private String treatedUsers;

    @Column(nullable = false)
    private Etat Etat;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public EtatObjetTicket getObjet() {
        return Objet;
    }

    public void setObjet(EtatObjetTicket objet) {
        Objet = objet;
    }

    public String getInitUser() {
        return initUser;
    }

    public void setInitUser(String initUser) {
        this.initUser = initUser;
    }

    public String getNextUser() {
        return nextUser;
    }

    public void setNextUser(String nextUser) {
        this.nextUser = nextUser;
    }

    public String getNextRole() {
        return nextRole;
    }

    public void setNextRole(String nextRole) {
        this.nextRole = nextRole;
    }

    public String getMotifs() {
        return motifs;
    }

    public void setMotifs(String motifs) {
        this.motifs = motifs;
    }

    public String getTreatedUsers() {
        return treatedUsers;
    }

    public void setTreatedUsers(String treatedUsers) {
        this.treatedUsers = treatedUsers;
    }

    public Etat getEtat() {
        return Etat;
    }

    public void setEtat(Etat etat) {
        Etat = etat;
    }

    public Ticket() {
    }

}
