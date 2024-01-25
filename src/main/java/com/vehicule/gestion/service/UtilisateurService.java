package com.vehicule.gestion.service;

import java.util.Optional;

import com.vehicule.gestion.modele.Utilisateur;
import com.vehicule.gestion.repository.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UtilisateurService {

  @Autowired
  private UtilisateurRepository utilisateurRepository;

  public Optional<Utilisateur> findByNameAndPassword(Utilisateur utilisateur) {
    System.out.println("tafididtra");

    Optional<Utilisateur> user = utilisateurRepository.findByMailAndMotDePasse(
      utilisateur.getMail(),
      utilisateur.getMotDePasse()
    );
    System.out.println(user);
    if (user.isPresent()) {
      System.out.println(user.get());
    }
    return user;
  }

  
  public Optional<Utilisateur> findByMail(String mail) {
    System.out.println("tafididtra");

    Optional<Utilisateur> user = utilisateurRepository.findByMail(mail);
    System.out.println(user);
    return user;
  }
}
