package com.lep.parcial;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.lep.parcial.entidades.Ciudad;

@SpringBootApplication
public class P4JulioWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(P4JulioWsApplication.class, args);
	}
	
	
}
