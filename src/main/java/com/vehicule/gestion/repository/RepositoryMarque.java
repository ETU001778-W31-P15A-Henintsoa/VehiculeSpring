package com.vehicule.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicule.gestion.modele.Marque;

@Repository
public interface RepositoryMarque extends JpaRepository<Marque, String> {
}
