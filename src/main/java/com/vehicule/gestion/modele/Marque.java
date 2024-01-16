package com.vehicule.gestion.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String idMarque;
    String nomMarque;
    String pays;

    public Marque() {
    }

    public Marque(String nomMarque) throws Exception {
        this.setNomMarque(nomMarque);
    }

    public Marque(String idMarque, String nomMarque) throws Exception {
        this.setIdMarque(idMarque);
        this.setNomMarque(nomMarque);
    }

    public String getIdMarque() {
        return this.idMarque;
    }

    public void setIdMarque(String idMarque) {
        this.idMarque = idMarque;
    }

    public String getNomMarque() {
        return this.nomMarque;
    }

    public void setNomMarque(String nomMarque) throws Exception {
        if (nomMarque == null || nomMarque.equals("")) {
            throw new Exception("Les Champs ne doivent pas etre vide(s).");
        }
        this.nomMarque = nomMarque;
    }

    public String getPays() {
        return this.pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public boolean controlExistanceMarqueByName(List<Marque> marqueExistant) throws Exception {
        for (Marque marque : marqueExistant) {
            if (marque.getNomMarque().equalsIgnoreCase(this.getNomMarque())) {
                return true;
            }
        }
        return false;
    }

    public boolean controlExistanceMarqueById(List<Marque> marqueExistant) throws Exception {
        for (Marque marque : marqueExistant) {
            if (marque.getIdMarque().equalsIgnoreCase(this.getIdMarque())) {
                return true;
            }
        }
        return false;
    }

}
