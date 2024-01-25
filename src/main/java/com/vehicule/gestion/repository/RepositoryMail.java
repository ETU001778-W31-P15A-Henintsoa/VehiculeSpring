package com.vehicule.gestion.repository;

import com.vehicule.gestion.modele.Mail;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMail extends MongoRepository<Mail, String> {

    // GroceryItem findItemByName(String name);

    // @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    // List<GroceryItem> findAll(String category);

    // public long count();

}
