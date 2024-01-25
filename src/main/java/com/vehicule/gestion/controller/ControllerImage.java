package com.vehicule.gestion.controller;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.TraitementImage;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerImage {

    @Autowired
    private Gson gson = new Gson();
    private ApiResponse reponse;

    @PostMapping("/traitementimage/{file}")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws Exception {
        TraitementImage timage = new TraitementImage();
        try {
            String pathfichier = timage.uploadImage(file);
            String test = timage.hebergementImage(pathfichier);
            return ResponseEntity.ok("Uploaded " + test + " .");
        } catch (Exception e) {
            e.printStackTrace();
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }
    }
}
