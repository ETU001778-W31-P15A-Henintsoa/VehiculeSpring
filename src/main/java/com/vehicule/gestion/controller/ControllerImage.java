package com.vehicule.gestion.controller;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.TraitementImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerImage {

    @Autowired
    private Gson gson = new Gson();
    private ApiResponse reponse;

    // @Transactional(rollbackOn = Exception.class)
    @GetMapping("/traitementimage}")
    public ResponseEntity<String> traitementImage() {
        try {
            TraitementImage timage = new TraitementImage();
            timage.setCheminLocal("C:/Users/ITU/Desktop/VehiculeSpring/img/Peugeot-405-02.jpg");
            return ResponseEntity.ok(timage.ImageToBase64());
        } catch (Exception e) {
            // e.printStackTrace();
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }
    }

}
