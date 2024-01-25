package com.vehicule.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.Modele;
import com.vehicule.gestion.service.ModeleService;

import jakarta.transaction.Transactional;

import java.util.List;

@RestController
@RequestMapping("/modele")
public class ModeleController {
    @Autowired
    private ModeleService modeleService;
    private Gson gson = new Gson();
    private ApiResponse reponse;

    @Transactional
    @PostMapping("/liste")
    public ResponseEntity<String> save(@RequestBody Modele c) throws Exception {
        List<Modele> categorie = modeleService.findAllByNomModele(c.getNomModele());
        if (c.isNomDeplacated(categorie) == false) {
            reponse = new ApiResponse("", modeleService.save(c));
            return ResponseEntity.ok(gson.toJson(reponse));
        }
        return ResponseEntity.status(500).body("Cette modele existe dejà");
    }
}
