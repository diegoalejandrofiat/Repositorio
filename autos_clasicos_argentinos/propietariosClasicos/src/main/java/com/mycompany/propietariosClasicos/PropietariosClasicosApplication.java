package com.mycompany.propietariosClasicos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class PropietariosClasicosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropietariosClasicosApplication.class, args);
	}

}
