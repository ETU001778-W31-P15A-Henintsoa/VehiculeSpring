package com.vehicule.gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.Categorie;
import com.vehicule.gestion.modele.Interet;
import com.vehicule.gestion.service.InteretService;

@RestController
public class ControllerInteret {
    @Autowired
    private InteretService entiteService;
    private Gson gson = new Gson();
    private ApiResponse response;

    @GetMapping("/interets")
    public ResponseEntity<String> getAll() {
        try {
            List<Interet> interets = entiteService.findAll();
            response = new ApiResponse("", interets);
            return ResponseEntity.ok(gson.toJson(response));
        } catch (Exception e) {
            response = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
