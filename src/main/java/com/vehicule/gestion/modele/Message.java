package com.vehicule.gestion.modele;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "message")
public class Message {
    @Id
    String idMessage;
    LocalDateTime dateMessage;
    Utilisateur idUtilisateurEnvoyeur;
    Utilisateur idUtilisateurReceveur;
    String message;
    List<String> liensImages;

    public Message() {
    }

    public Message(String dateMessage, Utilisateur idUtilisateurEnvoyeur, Utilisateur idUtilisateurReceveur,
            String message, List<String> liensImages) throws Exception {
        this.setDateMessage(dateMessage);
        this.idUtilisateurEnvoyeur = idUtilisateurEnvoyeur;
        this.idUtilisateurReceveur = idUtilisateurReceveur;
        this.message = message;
        this.liensImages = liensImages;
    }

    public String getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(String idMessage) {
        this.idMessage = idMessage;
    }

    public LocalDateTime getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(String dateMessage) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        this.dateMessage = LocalDateTime.parse(dateMessage, formatter);
    }

    public Utilisateur getIdUtilisateurEnvoyeur() {
        return idUtilisateurEnvoyeur;
    }

    public void setIdUtilisateurEnvoyeur(Utilisateur idUtilisateurEnvoyeur) {
        this.idUtilisateurEnvoyeur = idUtilisateurEnvoyeur;
    }

    public Utilisateur getIdUtilisateurReceveur() {
        return idUtilisateurReceveur;
    }

    public void setIdUtilisateurReceveur(Utilisateur idUtilisateurReceveur) {
        this.idUtilisateurReceveur = idUtilisateurReceveur;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getLiensImages() {
        return liensImages;
    }

    public void setLiensImages(List<String> liensImages) {
        this.liensImages = liensImages;
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

    public void setDateMessage(LocalDateTime dateMessage) {
        this.dateMessage = dateMessage;
    }

}
