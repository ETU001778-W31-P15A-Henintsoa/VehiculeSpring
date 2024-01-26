package com.vehicule.gestion.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.Annonce;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.Marque;
<<<<<<< Updated upstream
=======
import com.vehicule.gestion.modele.Utilisateur;
>>>>>>> Stashed changes
import com.vehicule.gestion.service.AnnonceService;
import com.vehicule.gestion.service.UtilisateurService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/annonce")
public class AnnonceController {

     @Autowired
    private AnnonceService annonceService;
    private Gson gson = new Gson();
    private ApiResponse reponse;
    @Autowired
    private UtilisateurService utilisateurService;

     @PostMapping("/Liste")
    public ResponseEntity<String> getList() {
        try {
            List<Annonce> annonce = annonceService.findAllByEtat(3);
            reponse = new ApiResponse("", annonce);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/Avalide")
    public ResponseEntity<String> valideAnnonce() {
        try {
            List<Annonce> annonce = annonceService.findAllByEtat(0);
            reponse = new ApiResponse("", annonce);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/mesListes")
    public ResponseEntity<String> avoirMesListes() {
        try {
             String mailUtilisateur = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());

            Utilisateur utilisateur = utilisateurService.findByMail(mailUtilisateur).get();
            List<Annonce> annonce = annonceService.findByUtilisateurAndEtat(utilisateur.getIdUtilisateur(),3);
            reponse = new ApiResponse("", annonce);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/mesListes")
    public ResponseEntity<String> avoirHistorique() {
        try {
             String mailUtilisateur = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());

            Utilisateur utilisateur = utilisateurService.findByMail(mailUtilisateur).get();
            List<Annonce> annonce = annonceService.findByUtilisateurAndEtat(utilisateur.getIdUtilisateur(),6);
            reponse = new ApiResponse("", annonce);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
 
    public List<Annonce> getValidedAnnonce(){
        return annonceService.findAllByEtat(1);
    }

    public List<Annonce> getNonValidedAnnonce(){
        return annonceService.findAllByEtat(0);
    }
    

    @Transactional
    @PostMapping("/annonce")
    public Annonce save(@RequestBody Annonce c)throws Exception{
        return annonceService.save(c);
    }
}
