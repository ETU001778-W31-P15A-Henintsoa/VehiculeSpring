package com.vehicule.gestion.modele;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MeilleurVendeur {
   @Id
   String idVendeur;
    @Column(name="nomutilisateur")
   String nomVendeur;
   int annee;
   int mois;
    int nombre;

public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

public int getMois() {
    return mois;
}

public void setMois(int mois) {
    this.mois = mois;
}

public int getAnnee() {
    return annee;
}

public void setAnnee(int annee) {
    this.annee = annee;
}

public String getNomVendeur() {
        return nomVendeur;
    }

    public void setNomVendeur(String nomVendeur) {
        this.nomVendeur = nomVendeur;
    }

public String getIdVendeur() {
    return idVendeur;
}

public void setIdVendeur(String idVendeur) {
    this.idVendeur = idVendeur;
}
}
