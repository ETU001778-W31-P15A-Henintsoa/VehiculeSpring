
package com.vehicule.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import com.vehicule.gestion.modele.Annonce;
import com.vehicule.gestion.repository.AnnonceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnnonceService {
    @Autowired
    private AnnonceRepository annonceRepositorie;

    public List<Annonce> findAll() {
        return annonceRepositorie.findAll();
    }

    public List<Annonce> findAllByIdAnnonce(String id) {
        return annonceRepositorie.findAllByIdAnnonce(id);
    }

    public Annonce save(Annonce c) {
        return annonceRepositorie.save(c);
    }

    public List<Annonce> findAllByEtat(int etat) {
        return annonceRepositorie.findAllByEtat(etat);
    }

    public List<Annonce> findByUtilisateurAndEtat(String idUtilisateur, int etat) {
        return annonceRepositorie.findByUtilisateurAndEtat(idUtilisateur, etat);
    }

    @Transactional
    public void update(String idAnnonce, int etat) throws Exception {
        // Retrieve the user entity from the database
        List<Annonce> annonceActuelle = annonceRepositorie.findAllByIdAnnonce(idAnnonce);

        if (annonceActuelle.size() != 0) {
            Annonce annonce = annonceActuelle.get(0);

            // Update the fields with new values
            annonce.setEtat(etat);
            // Save the updated entity back to the database
            annonceRepositorie.save(annonce);
        } else {
            throw new Exception("Annonc non Existant : " + idAnnonce);
        }
    }

}
