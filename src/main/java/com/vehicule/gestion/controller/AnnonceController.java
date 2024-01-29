package com.vehicule.gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.Annonce;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.MappingRecherche;
import com.vehicule.gestion.modele.Marque;
import com.vehicule.gestion.modele.Utilisateur;
import com.vehicule.gestion.service.AnnonceService;
import com.vehicule.gestion.service.UtilisateurService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
            List<Annonce> annonce = annonceService.findByUtilisateurAndEtat(utilisateur.getIdUtilisateur(), 3);
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
            List<Annonce> annonce = annonceService.findByUtilisateurAndEtat(utilisateur.getIdUtilisateur(), 6);
            reponse = new ApiResponse("", annonce);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    // @PostMapping("/rechercheAvance")
    // public ResponseEntity request(@RequestParam(value = "marque", required =
    // false) String marque,@RequestParam(value = "modele", required = false) String
    // modele,@RequestParam(value = "categorie", required = false) String
    // categorie,@RequestParam(value = "date1", required = false) String
    // date1,@RequestParam(value = "date2", required = false) String
    // date2,@RequestParam(value = "prix1", required = false) String
    // prix1,@RequestParam(value = "prix2", required = false) String prix2){
    // try{
    // List<Annonce> annonce = annonceService.rechercheAvance(marque, modele,
    // categorie, date1, date2, prix1, prix2);
    // System.out.println("eto");
    // reponse = new ApiResponse("", annonce);
    // return ResponseEntity.ok(gson.toJson(reponse));
    // } catch (Exception e) {
    // reponse = new ApiResponse(e.getMessage(), null);
    // return ResponseEntity.status(500).body(e.getMessage());
    // }
    // }

    @PostMapping("/rechercheAvance")
    public ResponseEntity request(@RequestBody MappingRecherche mapping) {
        try {
            List<Annonce> annonce = annonceService.rechercheAvance(mapping.getMarque(), mapping.getModele(),
                    mapping.getCategorie(), mapping.getDateMin(), mapping.getDateMax(), mapping.getPrixMin(),
                    mapping.getPrixMax());
            reponse = new ApiResponse("", annonce);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    public List<Annonce> getValidedAnnonce() {
        return annonceService.findAllByEtat(1);
    }

    public List<Annonce> getNonValidedAnnonce() {
        return annonceService.findAllByEtat(0);
    }

    @Transactional
    @PostMapping("/annonce")
    public Annonce save(@RequestBody Annonce c) throws Exception {
        return annonceService.save(c);
    }

    @Transactional
    @GetMapping("/MAJannonce/{idAnnonce}")
    public ResponseEntity<String> update(@PathVariable("idAnnonce") String idAnnonce) throws Exception {
        try {
            annonceService.update(idAnnonce, 3);
            return ResponseEntity.ok("Annonce " + idAnnonce + " validee");
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }
    }

}
