package com.vehicule.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.Categorie;
import com.vehicule.gestion.modele.Modele;
import com.vehicule.gestion.service.ModeleService;

import jakarta.transaction.Transactional;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ModeleController {
    @Autowired
    private ModeleService modeleService;
    private Gson gson = new Gson();
    private ApiResponse reponse;

    @GetMapping("/modeles")
    public ResponseEntity<String> findAll() throws Exception {
        try {
            List<Modele> categories = modeleService.findAll();
            reponse = new ApiResponse("", categories);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @Transactional
    @PostMapping("/modele")
    public ResponseEntity<String> save(@RequestBody Modele c) throws Exception {
        List<Modele> categorie = modeleService.findAllByNomModele(c.getNomModele());
        if (c.isNomDeplacated(categorie) == false) {
            reponse = new ApiResponse("", modeleService.save(c));
            return ResponseEntity.ok(gson.toJson(reponse));
        }
        return ResponseEntity.status(500).body("Cette modele existe dejà");
    }
}
