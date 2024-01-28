package com.vehicule.gestion.modele;

<<<<<<< Updated upstream
public class Interet {
    String idInteret;
    float valeur;
    

    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
=======
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Interet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String idInteret;
    float Taux;
    Date date;
    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTaux() {
        return Taux;
    }

    public void setTaux(float Taux) {
        this.Taux = Taux;
>>>>>>> Stashed changes
    }

    public String getIdInteret() {
        return idInteret;
    }

    public void setIdInteret(String idInteret) {
        this.idInteret = idInteret;
    }
}
