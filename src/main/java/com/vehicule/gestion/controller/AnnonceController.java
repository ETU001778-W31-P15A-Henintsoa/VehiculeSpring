package com.vehicule.gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.Annonce;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.Marque;
import com.vehicule.gestion.service.AnnonceService;
import jakarta.transaction.Transactional;

public class AnnonceController {

    @Autowired
    private AnnonceService annonceService;
    private Gson gson = new Gson();
    private ApiResponse reponse;

    @GetMapping("/annonce")
    public ResponseEntity<String> getAll() {
        try {
            List<Annonce> annonce = annonceService.findAllByEstVenduAndEstValide(false, false);
            reponse = new ApiResponse("", annonce);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    public ResponseEntity<String> getValidedAnnonce() {
        try {
            reponse = new ApiResponse("", annonceService.findAllByEtat(1));
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    public ResponseEntity<String> getNonValidedAnnonce() {
        try {
            reponse = new ApiResponse("", annonceService.findAllByEtat(0));
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @Transactional
    @PostMapping("/annonce")
    public ResponseEntity<String> save(@RequestBody Annonce c) throws Exception {
        try {
            reponse = new ApiResponse("", annonceService.save(c));
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(gson.toJson(reponse));
        }
    }
}
