package com.vehicule.gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicule.gestion.modele.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, String> {
    List<Categorie> findAll();

    List<Categorie> findAllById(String id);

    List<Categorie> findAllByNomCategorie(String nomCategorie);
}
