package com.vehicule.gestion.repository;

import com.vehicule.gestion.modele.Poussin;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPoussin extends MongoRepository<Poussin, String> {

    // GroceryItem findItemByName(String name);

    // @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    // List<GroceryItem> findAll(String category);

    // public long count();

}
