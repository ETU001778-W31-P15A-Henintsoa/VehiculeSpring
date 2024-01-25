package com.vehicule.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.FonctionnaliteTechnologique;
import com.vehicule.gestion.service.FonctionnaliteTechnologiqueService;

import jakarta.transaction.Transactional;

import java.util.List;

@RestController
@RequestMapping("/vehicule")
public class FonctionnaliteTechonologiqueController {
    @Autowired
    private FonctionnaliteTechnologiqueService entiteService;
    private Gson gson = new Gson();
    private ApiResponse reponse;

    @GetMapping("/fonctionnalite")
    public ResponseEntity<String> getAll() {
        try {
            reponse = new ApiResponse("", entiteService.findAll());
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    public List<FonctionnaliteTechnologique> findAllById(Iterable<String> id) {
        return entiteService.findAllById(id);
    }

    @Transactional
    @PostMapping("/fonctionnalite")
    public ResponseEntity<String> save(@RequestBody FonctionnaliteTechnologique c) throws Exception {
        List<FonctionnaliteTechnologique> FonctionnaliteTechonologique = entiteService
                .findAllByNomFonctionnaliteTechnologique(c.getNomFonctionnaliteTechonologique());
        if (c.isNomDuplicated(FonctionnaliteTechonologique) == false) {
            reponse = new ApiResponse("", entiteService.save(c));
            return ResponseEntity.ok(gson.toJson(reponse));
        }
        reponse = new ApiResponse("Cette catégorie existe dejà", null);
        return ResponseEntity.status(500).body("Cette catégorie existe dejà");
    }
}
