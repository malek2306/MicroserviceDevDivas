package com.microservice.livraison;

import com.microservice.livraison.Entities.Livraison;
import com.microservice.livraison.Entities.StatusLivraison;
import com.microservice.livraison.Repositories.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
@EnableDiscoveryClient
@SpringBootApplication
public class  LivraisonApplication {

    public static void main(String[] args) {
        SpringApplication.run(LivraisonApplication.class, args);
    }


    @Autowired
    private LivraisonRepository repository;
    @Bean
    ApplicationRunner init() {
        return (args) -> {
// save
            repository.save(new Livraison(LocalDate.of(2024,10,11), StatusLivraison.EnCours));
            repository.save(new Livraison(LocalDate.of(2024,10,25), StatusLivraison.EnCours));
            repository.save(new Livraison(LocalDate.of(2024,9,25), StatusLivraison.livré));
            repository.save(new Livraison(LocalDate.of(2024,7,25), StatusLivraison.annulé));
            repository.findAll().forEach(System.out::println);
        };

    }}