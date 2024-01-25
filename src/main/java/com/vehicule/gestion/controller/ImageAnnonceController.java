package com.vehicule.gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vehicule.gestion.modele.Annonce;
import com.vehicule.gestion.modele.ImageAnnonce;
import com.vehicule.gestion.service.AnnonceService;
import com.vehicule.gestion.service.ImageAnnonceService;

import jakarta.transaction.Transactional;

public class ImageAnnonceController {
     @Autowired
    private ImageAnnonceService entiteService;
    private AnnonceService annonceService;


    @GetMapping("/categorie")
    public List<ImageAnnonce> getAll() {
        return entiteService.findAll();
    }

    // public List<Categorie> findAllById(String id){
    //     return entiteService.findAllById(id);
    // }
    
    @Transactional
    @PostMapping("/imageAnnonce")
    public ImageAnnonce save(@RequestBody ImageAnnonce c,String idAnnonce)throws Exception{
        List<Annonce> annonces=annonceService.findAllByIdAnnonce(idAnnonce);
        if(annonces.size()>0){
            return entiteService.save(c);
        }
        throw new Exception("Cette annonce n'existe pas ");
    }

}
