package com.microservice.livraison.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Livraison implements Serializable {
    private static final long serialVersionUID = 6;

    @Id
    @GeneratedValue
    private int id;
    private LocalDate dateLivraison; // You may want to add @Column if you need specific column settings
    @Enumerated // This annotation is necessary if StatusLivraison is an enum
    private StatusLivraison statusLivraison;

    // No-argument constructor
    public Livraison() {
    }

    public Livraison(LocalDate dateLivraison, StatusLivraison statusLivraison) {
        this.dateLivraison = dateLivraison;
        this.statusLivraison = statusLivraison;
    }

    public int getId() {
        return id;
    }

    public StatusLivraison getStatusLivraison() {
        return statusLivraison;
    }

    public LocalDate getDateLivraison() {
        return dateLivraison;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateLivraison(LocalDate dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public void setStatusLivraison(StatusLivraison statusLivraison) {
        this.statusLivraison = statusLivraison;
    }
}
