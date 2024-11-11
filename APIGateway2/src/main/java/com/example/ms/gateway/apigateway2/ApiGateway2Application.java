package com.example.ms.gateway.apigateway2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableDiscoveryClient
public class ApiGateway2Application {

    public static void main(String[] args) {
        SpringApplication.run(ApiGateway2Application.class, args);
    }
    @Bean
    public RouteLocator getwayRoutes
            (RouteLocatorBuilder builder) {
        return builder.routes().

                route("gestion-commande",
                        r->r.path("/commandes/**").

                                uri("http://localhost:8084"))
                      //uri("http://commande:8084"))
                .build();


    }
}
