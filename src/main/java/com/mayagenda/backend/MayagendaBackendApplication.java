package com.mayagenda.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MayagendaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MayagendaBackendApplication.class, args);
	}

}
