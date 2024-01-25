package com.vehicule.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vehicule.gestion.modele.Modele;
import com.vehicule.gestion.service.ModeleService;

import jakarta.transaction.Transactional;

import java.util.List;

public class ModeleController {
     @Autowired
    private ModeleService modeleService;

    @Transactional
    @PostMapping("/liste")
    public Modele save(@RequestBody Modele c) throws Exception {
        List<Modele> categorie = modeleService.findAllByNomModele(c.getNomModele());
        if (c.isNomDeplacated(categorie) == false) {
            return modeleService.save(c);
        }
        throw new Exception("Cette modele existe dejà");
    }
}
