package com.vehicule.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;

import java.util.List;

// import java.util.List;
// import java.util.Optional;

import com.google.gson.Gson;
import com.jayway.jsonpath.internal.Path;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.Mail;
import com.vehicule.gestion.modele.Message;
import com.vehicule.gestion.modele.Poussin;
import com.vehicule.gestion.modele.Utilisateur;
import com.vehicule.gestion.service.ServiceMail;
import com.vehicule.gestion.service.ServiceMessage;
import com.vehicule.gestion.service.ServicePoussin;
import com.vehicule.gestion.service.UtilisateurService;

@RestController
// @RequestMapping("/api/people")
public class ControllerPoussin {

    @Autowired
    private ServicePoussin servicepoussin;
    private Gson gson = new Gson();
    private ApiResponse reponse;

    // Create operation
    @PostMapping("/poussin")
    public ResponseEntity<String> save() {
        try {
            Poussin p = new Poussin("mamamjgsdlgsjlkfdwjldvaaaaa");
            servicepoussin.save(p);
            return ResponseEntity.ok("Enregitree");
        } catch (Exception e) {
            e.printStackTrace();
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }
    }

}
