package com.vehicule.gestion.modele;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mail")
public class Mail {
    @Id
    String idMail;
    Utilisateur idUtilisateurEnvoyeur;
    Utilisateur idUtilisateurReceveur;

    public Mail() {
    }

    public Mail(Utilisateur idUtilisateurEnvoyeur, Utilisateur idUtilisateurReceveur,
            List<Utilisateur> listesUtilisateur) throws Exception {
        this.controlExistanceUtilisateurEnvoyeur(listesUtilisateur, idUtilisateurEnvoyeur);
        this.controlExistanceUtilisateurReceveur(listesUtilisateur, idUtilisateurReceveur);
        this.setIdMail(idMail);
        this.setIdUtilisateurEnvoyeur(idUtilisateurEnvoyeur);
        this.setIdUtilisateurReceveur(idUtilisateurReceveur);
    }

    public String getIdMail() {
        return this.idMail;
    }

    public void setIdMail(String idMail) {
        this.idMail = idMail;
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

    public void controlExistanceUtilisateurReceveur(List<Utilisateur> utilisateurExistant, Utilisateur user)
            throws Exception {
        boolean existant = false;
        for (Utilisateur utilisateur : utilisateurExistant) {
            if (utilisateur.getIdUtilisateur()
                    .equalsIgnoreCase(user.getIdUtilisateur())) {
                existant = true;
            }
        }
        if (existant == false) {
            throw new Exception("Utilisateur Receveur non Existant.");
        }
    }

    public void controlExistanceUtilisateurEnvoyeur(List<Utilisateur> utilisateurExistant, Utilisateur user)
            throws Exception {
        boolean existant = false;
        for (Utilisateur utilisateur : utilisateurExistant) {
            if (utilisateur.getIdUtilisateur().equalsIgnoreCase(user.getIdUtilisateur())) {
                existant = true;
            }
        }
        if (existant == false) {
            throw new Exception("Utilisateur Envoyer non Existant.");
        }

    }

}
