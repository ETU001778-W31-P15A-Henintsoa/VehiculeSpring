package com.vehicule.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import com.vehicule.gestion.modele.Mail;
import com.vehicule.gestion.repository.RepositoryMail;

@Service
@Transactional
public class ServiceMail {

    @Autowired
    private RepositoryMail personRepository;

    // Create operation
    public Mail save(Mail mail) {
        return personRepository.save(mail);
    }

    // Read operations
    public List<Mail> getAll() {
        return personRepository.findAll();
    }

    public Optional<Mail> getPersonById(String id) {
        return personRepository.findById(id);
    }

    // Update operation
    public Mail updatePerson(Mail person) {
        return personRepository.save(person);
    }

    // Delete operation
    public void deletePersonById(String id) {
        personRepository.deleteById(id);
    }
}
