package com.vehicule.gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicule.gestion.modele.Modele;

@Repository
public interface ModeleRepository extends JpaRepository<Modele, String> {
    List<Modele> findAll();

    List<Modele> findAllById(String id);

    List<Modele> findAllByNomModele(String nomModele);
}
