package tn.esprit.microservice.reclamation;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Reclamation {
    private static final long serialVersionUID = 6;

    @Id
    @GeneratedValue
    private int id;

    private String description;

    private Date date;

    @Enumerated
    private TypeReclamation typeReclamation;

    // Constructeur avec paramètres
    public Reclamation(String description, Date date, TypeReclamation typeReclamation) {
        this.description = description;
        this.date = date;
        this.typeReclamation = typeReclamation;
    }

    // Constructeur sans paramètres
    public Reclamation() {
    }

}
