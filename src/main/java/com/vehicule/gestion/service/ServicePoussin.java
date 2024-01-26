package com.vehicule.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import com.vehicule.gestion.modele.Mail;
import com.vehicule.gestion.modele.Poussin;
import com.vehicule.gestion.repository.RepositoryMail;
import com.vehicule.gestion.repository.RepositoryPoussin;

@Service
@Transactional
public class ServicePoussin {

    @Autowired
    private RepositoryPoussin personRepository;

    // Create operation
    public Poussin save(Poussin mail) {
        return personRepository.save(mail);
    }

    // Read operations
    public List<Poussin> getAll() {
        return personRepository.findAll();
    }
}
