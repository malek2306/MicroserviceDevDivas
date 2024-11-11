package com.esprit.ms.msmenu;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Dish {
    @Id
    @GeneratedValue
    private int id;

    private String nom;
    private String description;
    private double prix;
    private boolean disponibilite;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    @JsonIgnoreProperties("dishes")  // Ignore la liste des plats dans la catégorie pour éviter la boucle infinie
    private Categorie categorie;

    // Sérialiser uniquement le nom de la catégorie (au lieu de l'objet complet)
    @JsonProperty("categorie")
    public String getCategorieType() {
        return categorie != null ? categorie.getType().name() : null;
    }
}
