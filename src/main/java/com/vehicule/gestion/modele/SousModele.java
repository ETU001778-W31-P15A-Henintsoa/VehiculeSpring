package com.vehicule.gestion.modele;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SousModele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String idSousModele;

    @ManyToOne
    @JoinColumn(name = "idModele")
    Modele modele;
    String nomSous;
    float vitesseMax;
    float consommation;

    @ManyToOne
    @JoinColumn(name = "idTypeCarburant")
    TypeCarburant typeCarburant;
    boolean estManuel;
    float puissanceMoteur;
    float batterie;

    public float getBatterie() {
        return batterie;
    }

    public void setBatterie(float batterie) {
        this.batterie = batterie;
    }

    public boolean isEstManuel() {
        return estManuel;
    }

    public void setEstManuel(boolean estManuel) {
        this.estManuel = estManuel;
    }

    public float getConsommation() {
        return consommation;
    }

    public void setConsommation(float consommation)throws Exception {
        if(consommation<=0){
            throw new Exception("entrer une consommation valide");
        }
        this.consommation = consommation;
    }

    public String getNomSous() {
        return nomSous;
    }

    public void setNomSous(String nomSous) throws Exception{
        if(nomSous.equals("")|| nomSous==null){
            throw new Exception("Inserer d'abord le nom du modele");
        }
        this.nomSous = nomSous;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public String getIdSousModele() {
        return idSousModele;
    }

    public void setIdSousModele(String idSousModele) {
        this.idSousModele = idSousModele;
    }

    public float getMax() {
        return vitesseMax;
    }

    public void setMax(float max) throws Exception{
        if(max<=0){
            throw new Exception("entrer ube vitesse valide");
        }
        this.vitesseMax = max;
    }   

    public boolean isNomDuplacated(List<SousModele> modele){
        if(modele.size()>0){
             return true;
        }
        return false;
    }
}

