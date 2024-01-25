package com.vehicule.gestion.modele;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMail")
    String id;
    @ManyToOne
    // @JoinColumn(name = "idUtilisateurEnvoyeur")
    Utilisateur idUtilisateurEnvoyeur;
    @ManyToOne
    // @JoinColumn(name = "idUtilisateurReceveur")
    Utilisateur idUtilisateurReceveur;

    public Mail() {
    }

    public Mail(String idMail, Utilisateur idUtilisateurEnvoyeur, Utilisateur idUtilisateurReceveur) throws Exception {
        this.setIdMail(idMail);
        this.setIdUtilisateurEnvoyeur(idUtilisateurEnvoyeur);
        this.setIdUtilisateurReceveur(idUtilisateurReceveur);
    }

    public String getIdMail() {
        return this.id;
    }

    public void setIdMail(String idMail) {
        this.id = idMail;
    }

    public Utilisateur getIdUtilisateurEnvoyeur() {
        return this.idUtilisateurEnvoyeur;
    }

    public void setIdUtilisateurEnvoyeur(Utilisateur idUtilisateurEnvoyeur) {
        this.idUtilisateurEnvoyeur = idUtilisateurEnvoyeur;
    }

    public Utilisateur getIdUtilisateurReceveur() {
        return this.idUtilisateurReceveur;
    }

    public void setIdUtilisateurReceveur(Utilisateur idUtilisateurReceveur) {
        this.idUtilisateurReceveur = idUtilisateurReceveur;
    }

    public boolean controlExistanceUtilisateurReceveur(List<Utilisateur> utilisateurExistant) throws Exception {
        for (Utilisateur utilisateur : utilisateurExistant) {
            if (utilisateur.getIdUtilisateur().equalsIgnoreCase(this.getIdUtilisateurReceveur().getIdUtilisateur())) {
                return true;
            }
        }
        return false;
    }

    public boolean controlExistanceUtilisateurEnvoyeur(List<Utilisateur> utilisateurExistant) throws Exception {
        for (Utilisateur utilisateur : utilisateurExistant) {
            if (utilisateur.getIdUtilisateur().equalsIgnoreCase(this.getIdUtilisateurEnvoyeur().getIdUtilisateur())) {
                return true;
            }
        }
        return false;
    }

}
