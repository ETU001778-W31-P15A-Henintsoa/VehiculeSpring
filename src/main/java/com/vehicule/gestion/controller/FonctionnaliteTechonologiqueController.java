package com.vehicule.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< Updated upstream
=======
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
>>>>>>> Stashed changes
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vehicule.gestion.modele.FonctionnaliteTechnologique;
import com.vehicule.gestion.service.FonctionnaliteTechnologiqueService;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class FonctionnaliteTechonologiqueController {    
     @Autowired
    private FonctionnaliteTechnologiqueService entiteService;

    @GetMapping("/fonctionnalite")
    public List<FonctionnaliteTechnologique> getAll() {
        return entiteService.findAll();
    }

    public List<FonctionnaliteTechnologique> findAllById(Iterable<String> id){
        return entiteService.findAllById(id);
    }
    
    @Transactional
    @PostMapping("/fonctionnalite")
<<<<<<< Updated upstream
    public FonctionnaliteTechnologique save(@RequestBody FonctionnaliteTechnologique c)throws Exception{
        List<FonctionnaliteTechnologique> FonctionnaliteTechonologique=entiteService.findAllByNomFonctionnaliteTechnologique(c.getNomFonctionnaliteTechonologique());
        if(c.isNomDuplicated(FonctionnaliteTechonologique)==false){
            return entiteService.save(c);
=======
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> save(@RequestBody FonctionnaliteTechnologique c) throws Exception {
        List<FonctionnaliteTechnologique> FonctionnaliteTechonologique = entiteService
                .findAllByNomFonctionnaliteTechnologique(c.getNomFonctionnaliteTechonologique());
        if (c.isNomDuplicated(FonctionnaliteTechonologique) == false) {
            reponse = new ApiResponse("", entiteService.save(c));
            return ResponseEntity.ok(gson.toJson(reponse));
>>>>>>> Stashed changes
        }
        throw new Exception("Cette catégorie existe dejà");
    }
<<<<<<< Updated upstream
=======

    @Transactional
    @PostMapping("/fonctionnalite/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> postMethodName(@PathVariable("id") String id) {
        try {
            entiteService.delete(id);
            return ResponseEntity.ok("fonctionnalite " + id + " supprimé avec succes");
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }

    }

>>>>>>> Stashed changes
}
