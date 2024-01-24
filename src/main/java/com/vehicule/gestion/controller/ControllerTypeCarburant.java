package com.vehicule.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
// import java.util.Optional;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.TypeCarburant;
import com.vehicule.gestion.service.ServiceTypeCarburant;

@RestController
public class ControllerTypeCarburant {

    @Autowired
    private ServiceTypeCarburant servicetypecarburant;
    private Gson gson = new Gson();
    private ApiResponse reponse;

    @GetMapping("/typecarburants")
    public ResponseEntity<String> findAll() {
        try {
            List<TypeCarburant> lestypescarburants = servicetypecarburant.findAll();
            reponse = new ApiResponse("", lestypescarburants);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @Transactional(rollbackOn = Exception.class)
    @PostMapping("/typecarburant/{nomTypeCarburant}")
    public ResponseEntity<String> save(@PathVariable("nomTypeCarburant") String nomTypeCarburant) {
        try {
            TypeCarburant type = new TypeCarburant(nomTypeCarburant);
            servicetypecarburant.save(type);
            return ResponseEntity.ok("Marque saved successfully.");
        } catch (Exception e) {
            // e.printStackTrace();
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }

    }

    @GetMapping("/typecarburants/{id}")
    public ResponseEntity<String> findById(@PathVariable("id") String id) {
        try {
            Optional<TypeCarburant> lestypescarburants = servicetypecarburant.findById(id);
            reponse = new ApiResponse("", lestypescarburants);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    // @Transactional(rollbackOn = Exception.class)
    // @PostMapping("/typecarburant/delete/{id}")
    // public ResponseEntity<String> deleteById(@PathVariable("id") String id) {
    // try {
    // servicetypecarburant.deleteById(id);
    // return ResponseEntity.ok("Marque id = " + id + " deleted successfully.");
    // } catch (Exception e) {
    // // e.printStackTrace();
    // reponse = new ApiResponse(e.getMessage(), null);
    // return ResponseEntity.status(500).body(gson.toJson(reponse));
    // }
    // }
}