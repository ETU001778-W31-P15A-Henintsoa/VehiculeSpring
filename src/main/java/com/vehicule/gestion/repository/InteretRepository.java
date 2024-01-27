package com.vehicule.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicule.gestion.modele.ImageAnnonce;
import com.vehicule.gestion.modele.Interet;

public interface InteretRepository extends JpaRepository<Interet, String> {

}
