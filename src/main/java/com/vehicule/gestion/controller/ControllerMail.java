package com.vehicule.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.vehicule.gestion.modele.Mail;
import com.vehicule.gestion.service.ServiceMail;

import jakarta.transaction.Transactional;

import com.vehicule.gestion.modele.Mail;

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
    public Optional<Mail> findById(@PathVariable("id") String id) {
        Optional<Mail> mail = servicemail.findById(id);
        return mail;
    }
}
