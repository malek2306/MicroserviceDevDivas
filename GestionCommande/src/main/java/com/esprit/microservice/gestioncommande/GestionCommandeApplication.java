package com.esprit.microservice.gestioncommande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GestionCommandeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionCommandeApplication.class, args);
    }

}
