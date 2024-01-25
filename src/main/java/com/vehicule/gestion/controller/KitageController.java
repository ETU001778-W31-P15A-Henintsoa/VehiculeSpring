package com.vehicule.gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vehicule.gestion.modele.Annonce;
import com.vehicule.gestion.modele.Kitage;
import com.vehicule.gestion.service.AnnonceService;
import com.vehicule.gestion.service.KitageService;

import jakarta.transaction.Transactional;

public class KitageController {

    @Autowired
    private KitageService entiteService;
    private AnnonceService annonceService;

    @Transactional
    @PostMapping("/kitage")
    public Kitage save(@RequestBody Kitage c, String id) throws Exception {
        List<Annonce> annonce = annonceService.findAllByIdAnnonce(id);
        if (annonce.size() > 0) {
            return entiteService.save(c);
        }
        throw new Exception("Cette annonce nexiste pas");
    }

    //public List<Kitage> findAllById(String id,String idAnnonce){
      //  return entiteService.findAllByIdAnnonce(idAnnonce);
   // }
}
