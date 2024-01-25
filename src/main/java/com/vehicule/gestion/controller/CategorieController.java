package com.vehicule.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public Categorie save(@RequestBody Categorie c)throws Exception{
        List<Categorie> categorie=entiteService.findAllByNomCategorie(c.getNomCategorie());
        if(c.isNomDuplicated(categorie)==false){
            return entiteService.save(c);
        }
        throw new Exception("Cette catégorie existe dejà");
    }
}
