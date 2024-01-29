package com.vehicule.gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.Categorie;
import com.vehicule.gestion.modele.SousModele;
import com.vehicule.gestion.service.SousModeleService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/annonce")
public class SousModeleController {
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
    public ResponseEntity<String> save(@RequestBody SousModele c) throws Exception {
        List<SousModele> categorie = entiteService.findAllByNomSous(c.getNomSous());
        // if (c.isNomDuplacated(categorie) == false) {
        response = new ApiResponse("", entiteService.save(c));
        return ResponseEntity.ok(gson.toJson(response));
        // }
        // return ResponseEntity.status(500).body("Ce sous modele existe dejà");
    }

}
