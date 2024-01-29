package com.vehicule.gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< Updated upstream
=======
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vehicule.gestion.modele.SousModele;
import com.vehicule.gestion.service.SousModeleService;

import jakarta.transaction.Transactional;

public class SousModeleController {
<<<<<<< Updated upstream
     @Autowired
    private SousModeleService modeleService;

    @Transactional
    @PostMapping("/sousmodele")
    public SousModele save(@RequestBody SousModele c) throws Exception {
        List<SousModele> categorie = modeleService.findAllByNomSous(c.getNomSous());
=======
    @Autowired
    private SousModeleService entiteService;
    private Gson gson = new Gson();
    private ApiResponse response;

    @GetMapping("/sousModeles")

    public ResponseEntity<String> findAll() {
        try {
            List<SousModele> categories = entiteService.findAll();
            response = new ApiResponse("", categories);
            return ResponseEntity.ok(gson.toJson(response));
        } catch (Exception e) {
            response = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/SousModele/{id}")
    public ResponseEntity<String> findAllById(@PathVariable("id") String idCategorie) {
        try {
            List<SousModele> categorie = entiteService.findAllByIdSousModele(idCategorie);
            response = new ApiResponse("", categorie);
            return ResponseEntity.ok(gson.toJson(response));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/SousModeleByNom/{nom}")
    public ResponseEntity<String> findAllByNomSous(@PathVariable("nom") String idCategorie) {
        try {
            List<SousModele> categorie = entiteService.findAllByNomSous(idCategorie);
            response = new ApiResponse("", categorie);
            return ResponseEntity.ok(gson.toJson(response));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @Transactional
    @PostMapping("/sousmodele")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> save(@RequestBody SousModele c) throws Exception {
        List<SousModele> categorie = entiteService.findAllByNomSous(c.getNomSous());
>>>>>>> Stashed changes
        if (c.isNomDuplacated(categorie) == false) {
            return modeleService.save(c);
        }
        throw new Exception("Ce sous modele existe dejà");
    }
}
