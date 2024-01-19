package com.vehicule.gestion.modele;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

import lombok.Data;

@Entity
@Data
public class Marque {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Marque")
    String id;
    String nom_Marque;
    String pays;

    public Marque() {
    }

    public Marque(String nom_Marque) throws Exception {
        this.setNomMarque(nom_Marque);
    }

    public Marque(String nom_Marque, String pays) throws Exception {
        this.setNomMarque(nom_Marque);
        this.setPays(pays);
    }

    public String getId_Marque() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomMarque() {
        return this.nom_Marque;
    }

    public void setNomMarque(String nom_Marque) throws Exception {
        if (nom_Marque == null || nom_Marque.equals("")) {
            throw new Exception("Les Champs ne doivent pas etre vide(s).");
        }
        this.nom_Marque = nom_Marque;
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
            if (marque.getId_Marque().equalsIgnoreCase(this.getId_Marque())) {
                return true;
            }
        }
        return false;
    }

}
