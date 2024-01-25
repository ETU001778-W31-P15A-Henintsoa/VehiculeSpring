package com.vehicule.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.vehicule.gestion.modele.Mail;

@Repository
public interface RepositoryMail extends JpaRepository<Mail, Long> {
    List<Mail> findAll();

    // boolean controlcombiner(List<Mail> marqueExistant);
}
