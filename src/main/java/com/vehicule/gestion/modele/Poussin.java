package com.vehicule.gestion.modele;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "poussin")
public class Poussin {
    @Id
    String idpoussin;

    public Poussin() {
    }

    public Poussin(String idpoussin) {
        this.idpoussin = idpoussin;
    }

    public String getIdpoussin() {
        return idpoussin;
    }

    public void setIdpoussin(String idpoussin) {
        this.idpoussin = idpoussin;
    }

}
