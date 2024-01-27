package com.vehicule.gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vehicule.gestion.modele.Annonce;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, String> {
    List<Annonce> findAll();

    List<Annonce> findAllByIdAnnonce(String id);

    List<Annonce> findAllByEtat(int etat);

    @Query(value = "SELECT a FROM annonce a WHERE a.utilisateur.id = :idutilisateur and a.etat<= :etat and a.etat>0")
    List<Annonce> findByUtilisateurAndEtat(@Param("idutilisateur") String idUtilisateur, @Param("etat") int etat);
}
