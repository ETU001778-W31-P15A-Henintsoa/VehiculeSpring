package com.vehicule.gestion.modele;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idannonce")
    String idAnnonce;

    @ManyToOne
    @JoinColumn(name = "idutilisateur")
    Utilisateur utilisateur;

    @OneToOne
    @JoinColumn(name = "idsousmodele")
    SousModele sousModele;
    String couleur;
    float prix;
    @Column(name="prixminimum")
    float prixMinimum;
    @Column(name="dateannonce")
    Timestamp dateAnnonce;
    int etat;

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Timestamp getDateAnnonce() {
        return dateAnnonce;
    }

    public void setDateAnnonce(Timestamp dateAnnonce) {
        this.dateAnnonce = dateAnnonce;
        if(dateAnnonce==null){
            dateAnnonce=Timestamp.valueOf(LocalDateTime.now());
        }
    }

    public float getPrixMinimum() {
        return prixMinimum;
    }

    public void setPrixMinimum(float prixMinimum) throws Exception{
        if(prixMinimum<=0){
            throw new Exception("Prix minimum non valide");
        }
        this.prixMinimum = prixMinimum;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) throws Exception{
        if(prix<=0){
            throw new Exception("Prix  non valide");
        }
        this.prix = prix;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        
        this.couleur = couleur;
    }

    public SousModele getSousModele() {
        return sousModele;
    }

    public void setSousModele(SousModele sousModele) {
        this.sousModele = sousModele;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(String idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    // public boolean isNomDuplacated(List<SousModele> modele){
    //     if(modele.size()>0){
    //          return true;
    //     }
    // }
}
