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

import com.vehicule.gestion.modele.Mail;
import com.vehicule.gestion.service.ServiceMail;

@RestController
public class ControllerMail {

    @Autowired
    private ServiceMail servicemail;

    @GetMapping("/mail")
    public List<Mail> findAll() {
        List<Mail> lesMails = servicemail.findAll();
        return lesMails;
    }

    @Transactional
    @PostMapping("/mail")
    public Mail save(@RequestBody Mail mail) {
        return servicemail.save(mail);
    }

    @GetMapping("/mail/{id}")
    public Optional<Mail> findById(@PathVariable("id") int id) {
        Optional<Mail> mail = servicemail.findById(id);
        return mail;
    }
}
