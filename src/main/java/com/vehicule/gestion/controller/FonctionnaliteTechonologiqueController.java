package com.vehicule.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public FonctionnaliteTechnologique save(@RequestBody FonctionnaliteTechnologique c)throws Exception{
        List<FonctionnaliteTechnologique> FonctionnaliteTechonologique=entiteService.findAllByNomFonctionnaliteTechnologique(c.getNomFonctionnaliteTechonologique());
        if(c.isNomDuplicated(FonctionnaliteTechonologique)==false){
            return entiteService.save(c);
        }
        throw new Exception("Cette catégorie existe dejà");
    }
}
