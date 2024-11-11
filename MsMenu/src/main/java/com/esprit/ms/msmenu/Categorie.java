package com.esprit.ms.msmenu;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Setter
@Getter
public class Categorie {
    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("categorie") // Ignore la propriété "categorie" dans chaque "Dish"
    private List<Dish> dishes;

    // Sérialiser uniquement le type (en tant que String) et ne pas inclure l'objet complet "Dish"
    @JsonProperty("type")
    public String getTypeString() {
        return type != null ? type.name() : null;
    }

    @JsonProperty("dishes")
    public List<String> getDishNames() {
        return dishes != null ? dishes.stream()
                .map(Dish::getNom) // Récupérer uniquement le nom des plats
                .collect(Collectors.toList())
                : List.of(); // Liste vide si aucun plat
    }

}
