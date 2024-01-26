package com.vehicule.gestion.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vehicule.gestion.modele.Message;

@Repository
public interface RepositoryMessage extends MongoRepository<Message, String> {

}
