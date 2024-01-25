package com.vehicule.gestion.repository;

import com.vehicule.gestion.modele.Mail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMail extends JpaRepository<Mail, String> {
}
