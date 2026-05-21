package com.gp.registroFaenas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RegistroFaenasApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroFaenasApplication.class, args);
	}

}
