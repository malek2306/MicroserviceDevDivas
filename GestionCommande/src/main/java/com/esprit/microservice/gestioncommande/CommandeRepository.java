package com.esprit.microservice.gestioncommande;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CommandeRepository extends JpaRepository<Commande, Integer> {
}
