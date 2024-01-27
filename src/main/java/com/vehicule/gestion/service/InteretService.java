package com.vehicule.gestion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.gestion.modele.Interet;
import com.vehicule.gestion.modele.SousModele;

@Service
public class InteretService {
    @Autowired
    private InteretService interetService;

    public List<Interet> findAll() {
        return interetService.findAll();
    }

    public Interet save(Interet c) {
        return interetService.save(c);
    }

    public void deletById(String id) {
        interetService.deletById(id);
    }

}
