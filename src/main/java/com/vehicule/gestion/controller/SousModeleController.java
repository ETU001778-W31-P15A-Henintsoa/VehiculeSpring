package com.vehicule.gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vehicule.gestion.modele.SousModele;
import com.vehicule.gestion.service.SousModeleService;

import jakarta.transaction.Transactional;

public class SousModeleController {
     @Autowired
    private SousModeleService modeleService;

    @Transactional
    @PostMapping("/sousmodele")
    public SousModele save(@RequestBody SousModele c) throws Exception {
        List<SousModele> categorie = modeleService.findAllByNomSous(c.getNomSous());
        if (c.isNomDuplacated(categorie) == false) {
            return modeleService.save(c);
        }
        throw new Exception("Ce sous modele existe dejà");
    }
}
