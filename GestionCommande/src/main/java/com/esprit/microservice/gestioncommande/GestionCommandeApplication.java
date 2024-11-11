package com.esprit.microservice.gestioncommande;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient

public class GestionCommandeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionCommandeApplication.class, args);
    }
    @Bean
    ApplicationRunner init(CommandeRepository commandeRepository) {
        return (args) -> {
            // Enregistrer des commandes d'exemple
            commandeRepository.save(new Commande("Produit A", 10, false));
            commandeRepository.save(new Commande("Produit B", 5, true));
            commandeRepository.save(new Commande("Produit C", 15, false));
            commandeRepository.save(new Commande("Produit D", 20, true));

            // Afficher toutes les commandes
            commandeRepository.findAll().forEach(System.out::println);
        };
    }
}
