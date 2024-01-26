package com.vehicule.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.Categorie;
import com.vehicule.gestion.service.CategorieService;

import jakarta.transaction.Transactional;

import java.util.List;

@RestController
public class CategorieController {
    @Autowired
    private CategorieService entiteService;
    private Gson gson = new Gson();
    private ApiResponse response;

    @GetMapping("/categorie")
    public ResponseEntity<String> getAll() {
        try {
            List<Categorie> categories = entiteService.findAll();
            response = new ApiResponse("", categories);
            return ResponseEntity.ok(gson.toJson(response));
        } catch (Exception e) {
            response = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/categories/{id_categorie}")
    public ResponseEntity<String> findAllById(@PathVariable("id_categorie") String idCategorie) {
        try {
            List<Categorie> categorie = entiteService.findAllById(idCategorie);
            response = new ApiResponse("", categorie);
            return ResponseEntity.ok(gson.toJson(response));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @Transactional
    @PostMapping("/categorie")
    public Categorie save(@RequestBody Categorie c) throws Exception {
        List<Categorie> categorie = entiteService.findAllByNomCategorie(c.getNomCategorie());
        if (c.isNomDuplicated(categorie) == false) {
            return entiteService.save(c);
        }
        throw new Exception("Cette catégorie existe dejà");
    }
}
