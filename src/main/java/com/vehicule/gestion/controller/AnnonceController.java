package com.vehicule.gestion.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.Annonce;
import com.vehicule.gestion.modele.ApiResponse;
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
            List<Annonce> annonce = annonceService.findAllByEstVenduAndEstValide(false,false);
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
