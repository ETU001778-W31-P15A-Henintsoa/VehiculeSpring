package com.vehicule.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vehicule.gestion.modele.TraitementImage;

@Repository
public interface RepositoryImage extends JpaRepository<TraitementImage, String> {

}
