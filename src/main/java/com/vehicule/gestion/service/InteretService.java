package com.vehicule.gestion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.gestion.modele.Interet;
import com.vehicule.gestion.modele.SousModele;
import com.vehicule.gestion.repository.InteretRepository;

@Service
public class InteretService {
    @Autowired
    private InteretRepository interetRepository;

    public List<Interet> findAll() {
        return interetRepository.findAll();
    }

    public Interet save(Interet c) {
        return interetRepository.save(c);
    }

    public void deleteById(String id) {
        interetRepository.deleteById(id);
    }

}
