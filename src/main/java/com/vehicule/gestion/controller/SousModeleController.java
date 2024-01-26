package com.vehicule.gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.SousModele;
import com.vehicule.gestion.service.SousModeleService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/annonce")
public class SousModeleController {
    @Autowired
    private SousModeleService modeleService;
    private Gson gson = new Gson();
    private ApiResponse reponse;

    @Transactional
    @PostMapping("/sousmodele")
    public ResponseEntity<String> save(@RequestBody SousModele c) throws Exception {
        List<SousModele> categorie = modeleService.findAllByNomSous(c.getNomSous());
        if (c.isNomDuplacated(categorie) == false) {
            reponse = new ApiResponse("", modeleService.save(c));
            return ResponseEntity.ok(gson.toJson(reponse));
        }
        return ResponseEntity.status(500).body("Ce sous modele existe dejà");
    }

}
