package com.gp.contratosPersonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ContratosPersonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContratosPersonalApplication.class, args);
	}

}
