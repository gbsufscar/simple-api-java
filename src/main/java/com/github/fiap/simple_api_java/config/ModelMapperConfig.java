package com.github.fiap.simple_api_java.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
 * O código define uma classe de configuração do Spring chamada ModelMapperConfig. 
 * Dentro dessa classe, é declarado um método anotado com @Bean que cria e retorna uma 
 * instância de ModelMapper. Isso permite que o Spring gerencie essa instância e a 
 * injete em outras partes da aplicação conforme necessário.
 */
@Configuration // Define a classe como uma classe de configuração do Spring
public class ModelMapperConfig { // Define a classe ModelMapperConfig

    @Bean // Define um bean gerenciado pelo Spring
    public ModelMapper modelMapper() {
        return new ModelMapper(); // Cria e retorna uma instância de ModelMapper
    }
}

