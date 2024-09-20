package com.github.fiap.simple_api_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
 * A classe Application é a classe principal da aplicação Spring Boot. 
 * Sua função é inicializar e configurar a aplicação. 
 * A classe Application é responsável por iniciar a aplicação Spring Boot e 
 * configurar o ambiente necessário para que a aplicação funcione corretamente.

 */
@SpringBootApplication // Anotação que marca esta classe como a principal da aplicação Spring Boot
public class Application {

	public static void main(String[] args) { // 
		// Método principal que inicializa a aplicação Spring Boot
		SpringApplication.run(Application.class, args);
	}

}
