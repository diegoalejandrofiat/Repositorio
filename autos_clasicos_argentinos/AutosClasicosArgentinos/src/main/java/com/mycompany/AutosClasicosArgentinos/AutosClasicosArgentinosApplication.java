package com.mycompany.AutosClasicosArgentinos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AutosClasicosArgentinosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutosClasicosArgentinosApplication.class, args);
	}

}
