package com.vehicule.gestion.controller;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.Marque;
import com.vehicule.gestion.service.ServiceMarque;

@RestController
public class ControllerMarque {

    @Autowired
    private ServiceMarque servicemarque;
    private Gson gson = new Gson();
    private ApiResponse reponse;

    @GetMapping("/marques")
    public ResponseEntity<String> findAll() {
        try {
            List<Marque> lesMarques = servicemarque.findAll();
            reponse = new ApiResponse("", lesMarques);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @Transactional(rollbackOn = Exception.class)
    @PostMapping("/marque/{nom_marque}/{pays}")
    public ResponseEntity<String> save(@PathVariable("nom_marque") String nomMarque,
            @PathVariable("pays") String pays) {
        try {
            Marque marque = new Marque(nomMarque, pays);
            servicemarque.save(marque);
            return ResponseEntity.ok("Marque saved successfully.");
        } catch (Exception e) {
            // e.printStackTrace();
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }

    }

    @GetMapping("/marques/{id_marque}")
    public Optional<Marque> findById(@PathVariable("id_marque") String id_marque) {
        Optional<Marque> marque = servicemarque.findById(id_marque);
        return marque;
    }

    @GetMapping("/marques/{id_marque}")
    public Optional<Marque> deleteById(@PathVariable("id_marque") String id_marque) {
        servicemarque.deleteById(id_marque);
        return marque;
    }

}
