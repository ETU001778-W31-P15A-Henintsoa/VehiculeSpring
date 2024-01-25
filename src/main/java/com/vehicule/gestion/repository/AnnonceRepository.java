package com.vehicule.gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicule.gestion.modele.Annonce;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, String> {
    List<Annonce> findAll();

    List<Annonce> findAllByIdAnnonce(String id);

    List<Annonce> findAllByEtat(int etat);

    List<Annonce> findAllByEstVenduAndEstValide(boolean estVendu,boolean estValide);

    // List<Categorie> findAllByNomCategorie(String nomCategorie);
}
