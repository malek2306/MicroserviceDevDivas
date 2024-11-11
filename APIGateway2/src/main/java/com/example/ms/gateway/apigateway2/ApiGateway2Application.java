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
                route("produitp",
                        r->r.path("/produitsPrimaires/**").
                                //uri("http://produitprimaire:8081"))
                                //uri("http://localhost:8081"))

                                  uri("http://produitprimaire:8087"))
                                       // uri("http://localhost:8087"))



                .route("GestionCommande",
                        r->r.path("/commandes/**").

                               // uri("http://localhost:8084"))
                      uri("http://commande:8084"))



                .route("Reclamation",
                        r->r.path("/reclamation/**").

                                //uri("http://localhost:8090"))
                     uri("http://reclamation:8090"))


                .route("Livraison",
                        r->r.path("/livraison/**").

                                //uri("http://localhost:8082"))
                     uri("http://livraison:8082"))



                .route("MsMenu",
                        r->r.path("/Dishes/**").

                                //uri("http://localhost:9091"))
                      uri("http://menu:9091"))

                .route("MsMenu",
                        r->r.path("/Categories/**").
                                 uri("http://menu:9091"))

                                       // uri("http://localhost:9091"))
                .build();


    }
}
