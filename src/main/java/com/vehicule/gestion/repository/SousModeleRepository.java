package com.vehicule.gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicule.gestion.modele.SousModele;

@Repository
public interface SousModeleRepository extends JpaRepository<SousModele, String> {
    List<SousModele> findAll();

    List<SousModele> findAllByIdSousModele(String id);

    List<SousModele> findAllByNomSous(String nomSous);
}
