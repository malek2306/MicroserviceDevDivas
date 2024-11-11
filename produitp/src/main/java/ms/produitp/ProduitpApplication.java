package ms.produitp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProduitpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProduitpApplication.class, args);
	}

}
