
package com.vehicule.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.gestion.modele.Annonce;
import com.vehicule.gestion.repository.AnnonceRepository;

import java.util.List;

@Service
public class AnnonceService {    
    @Autowired
    private AnnonceRepository annonceRepositorie;

    public List<Annonce> findAll(){
        return annonceRepositorie.findAll();
    }

    public List<Annonce> findAllByIdAnnonce(String id){
        return annonceRepositorie.findAllByIdAnnonce(id);
    }

    public Annonce save(Annonce c){
        return annonceRepositorie.save(c);
    }
    public List<Annonce> findAllByEtat(int etat){
        return annonceRepositorie.findAllByEtat(etat);
    }

    public List<Annonce> findByUtilisateurAndEtat(String idUtilisateur,int etat){
        return annonceRepositorie.findByUtilisateurAndEtat(idUtilisateur, etat);
    }
    // public List<Annonce> findAllByU

}
