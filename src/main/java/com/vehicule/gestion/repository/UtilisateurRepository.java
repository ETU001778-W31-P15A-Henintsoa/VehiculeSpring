// package com.vehicule.gestion.repository;

// import com.vehicule.gestion.modele.Utilisateur;
// import java.util.Optional;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

<<<<<<< Updated upstream
// @Repository
// public interface UtilisateurRepository
//   extends JpaRepository<Utilisateur, String> {
//   Optional<Utilisateur> findByMailAndMotDePasse(
//     String login,
//     String motdepasse
//   );
//   Optional<Utilisateur> findByMail(String login);
=======
@Repository
public interface UtilisateurRepository
  extends JpaRepository<Utilisateur, String> {
  Optional<Utilisateur> findByMailAndMotDePasse(
    String login,
    String motdepasse
  );
  Optional<Utilisateur> findByMail(String login);

>>>>>>> Stashed changes



// }
