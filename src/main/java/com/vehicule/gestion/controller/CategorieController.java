package com.vehicule.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< Updated upstream
import org.springframework.stereotype.Service;
=======
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vehicule.gestion.modele.Categorie;
import com.vehicule.gestion.service.CategorieService;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class CategorieController {    
     @Autowired
    private CategorieService entiteService;

    @GetMapping("/categorie")
    public List<Categorie> getAll() {
        return entiteService.findAll();
    }

    public List<Categorie> findAllById(Iterable<String> id){
        return entiteService.findAllById(id);
    }
    
    @Transactional
    @PostMapping("/categorie")
<<<<<<< Updated upstream
    public Categorie save(@RequestBody Categorie c)throws Exception{
        List<Categorie> categorie=entiteService.findAllByNomCategorie(c.getNomCategorie());
        if(c.isNomDuplicated(categorie)==false){
            return entiteService.save(c);
=======
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> save(@RequestBody Categorie c) {
        try {
            List<Categorie> categorie = entiteService.findAllByNomCategorie(c.getNomCategorie());
            if (c.isNomDuplicated(categorie) == false) {
                response = new ApiResponse("", entiteService.save(c));
                return ResponseEntity.ok(gson.toJson(response));
            }
            return ResponseEntity.status(500).body("Cette catégorie existe dejà");

        } catch (Exception e) {
            e.printStackTrace();
            response = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(response));
>>>>>>> Stashed changes
        }
        throw new Exception("Cette catégorie existe dejà");
    }
<<<<<<< Updated upstream
=======

    @Transactional
    @PostMapping("/suppressionCategorie/{id_categorie}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@PathVariable("id_categorie") String idCategorie) {
        try {
            entiteService.delete(idCategorie);
            return ResponseEntity.ok("Suppression reussie");
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }

    }

>>>>>>> Stashed changes
}
