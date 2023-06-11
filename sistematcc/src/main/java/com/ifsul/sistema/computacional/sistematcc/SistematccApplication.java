package com.ifsul.sistema.computacional.sistematcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}) //excluir temporariamente a segurança de login
public class SistematccApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistematccApplication.class, args);
		
	}

}
