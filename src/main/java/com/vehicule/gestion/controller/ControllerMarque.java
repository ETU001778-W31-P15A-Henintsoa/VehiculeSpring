package com.vehicule.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.vehicule.gestion.modele.Marque;
import com.vehicule.gestion.service.ServiceMarque;

@RestController
public class ControllerMarque {

    @Autowired
    private ServiceMarque servicemarque;

    @GetMapping("/marques")
    public List<Marque> findAll() {
        List<Marque> lesMarques = servicemarque.findAll();
        return lesMarques;
    }

    @Transactional
    @PostMapping("/marque")
    public Marque save(@RequestBody Marque marque) {
        return servicemarque.save(marque);
    }

    @GetMapping("/marque/{id}")
    public Optional<Marque> findById(@PathVariable("id") int id) {
        Optional<Marque> marque = servicemarque.findById(id);
        return marque;
    }
}
