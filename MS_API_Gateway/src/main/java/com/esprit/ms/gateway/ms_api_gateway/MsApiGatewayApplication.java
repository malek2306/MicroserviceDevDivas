package com.esprit.ms.gateway.ms_api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MsApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsApiGatewayApplication.class, args);
    }


    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("Reclamation",
                        r -> r.path("/reclamation/**")
                        .uri("http://reclamation:8090"))



                .build();
    }
}
