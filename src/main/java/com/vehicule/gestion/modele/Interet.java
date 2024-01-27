package com.vehicule.gestion.modele;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Interet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idinteret")
    String idInteret;
    float taux;

    public float getTaux() {
        return taux;
    }

    public void setTaux(float taux) {
        this.taux = taux;
    }

    public String getIdInteret() {
        return idInteret;
    }

    public void setIdInteret(String idInteret) {
        this.idInteret = idInteret;
    }
}
