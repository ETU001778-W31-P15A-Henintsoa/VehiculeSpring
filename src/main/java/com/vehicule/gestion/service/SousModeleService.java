package com.vehicule.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.gestion.modele.SousModele;
import com.vehicule.gestion.repository.SousModeleRepository;

import java.util.List;

@Service
public class SousModeleService {    
    @Autowired
    private SousModeleRepository sousService;

    public List<SousModele> findAll(){
        return sousService.findAll();
    }

    public List<SousModele> findAllByIdSousModele(String id){
        return sousService.findAllByIdSousModele(id);
    }
    public List<SousModele> findAllByNomSous(String nom){
        return sousService.findAllByNomSous(nom);
    }

    public SousModele save(SousModele c){
        return sousService.save(c);
    }

    public void update(String id,String modele,String nom,float vitesse,float conso,String carbu,boolean manuel,float moteur,float batterie){
         sousService.update(modele, modele, nom, vitesse, conso, carbu, manuel, moteur, batterie);
    }
    
}
