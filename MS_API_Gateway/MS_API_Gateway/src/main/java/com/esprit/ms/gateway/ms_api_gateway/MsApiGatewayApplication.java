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
	public RouteLocator getwayRoutes
		(RouteLocatorBuilder builder)
{
return builder.routes().
		route("MSCandidat_5SAE1",
		r->r.path("/candidats/**").
				uri("http://localhost:8080"))//MS candidat ==> 8080
		.route("MS_job_s",
				r->r.path("/jobs/**").
						uri("http://localhost:8083"))//MS Job ==> 8083

		.build();
}
}
