package com.esprit.ms.msmenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MsMenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMenuApplication.class, args);
	}

	@Autowired
	private CategorieRepository categorieRepository;  // Utilisation de @Autowired pour injecter le repository

	@Autowired
	private DishRepository dishRepository;  // Utilisation de @Autowired pour injecter le repository

	@Bean
	ApplicationRunner init() {
		return (args) -> {

			System.out.println("Catégories :");
			categorieRepository.findAll().forEach(System.out::println);

			// Fetch et affichage de tous les plats
			System.out.println("DISH :");
			dishRepository.findAll().forEach(System.out::println);
		};
	}
}
