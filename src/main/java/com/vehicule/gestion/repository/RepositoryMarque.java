package com.vehicule.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.vehicule.gestion.modele.Marque;

@Repository
public interface RepositoryMarque extends JpaRepository<Marque, Long> {
    List<Marque> findAll();

    Optional<Marque> findById(String id_Marque);

    Optional<Marque> deleteById(String id);
}
