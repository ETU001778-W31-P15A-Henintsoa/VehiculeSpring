package com.vehicule.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.vehicule.gestion.modele.Mail;
import com.vehicule.gestion.repository.RepositoryMail;

@Service
public class ServiceMail {
    @Autowired
    private RepositoryMail repositoryMail;

    public List<Mail> findAll() {
        return repositoryMail.findAll();
    }

    public Mail save(Mail mail) {
        return repositoryMail.save(mail);
    }

    public Optional<Mail> findById(String id) {
        return repositoryMail.findById(id);
    }

    public void deleteById(String id) {
        repositoryMail.deleteById(id);
    }

}
