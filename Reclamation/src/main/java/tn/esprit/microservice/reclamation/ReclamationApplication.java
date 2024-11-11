package tn.esprit.microservice.reclamation;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class ReclamationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReclamationApplication.class, args);
    }


    @Autowired
    private ReclamationRepository repository;
    @Bean
    ApplicationRunner init() {
        return args -> {
            repository.save(new Reclamation("Problème technique", new Date(), TypeReclamation.PROBLEME_TECHNIQUE));

        };
    }
}
