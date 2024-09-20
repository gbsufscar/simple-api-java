package com.github.fiap.simple_api_java.dto;

import org.modelmapper.ModelMapper;

import com.github.fiap.simple_api_java.model.Produto;

import lombok.Getter;
import lombok.Setter;

/*
 * A classe ProdutoCreateDto é um Data Transfer Object (DTO) usado para transferir 
 * dados de criação de um produto entre a camada de apresentação (como um controlador REST) e 
 * a camada de serviço. 
 * Ele contém os dados necessários para criar um novo produto e fornece um método para 
 * converter esses dados em uma entidade Produto. DTO é uma prática comum para separar 
 * a lógica de negócios da lógica de apresentação e manter a API RESTful.
 */

@Getter // Gera automaticamente os métodos getters para os campos da classe
@Setter // Gera automaticamente os métodos setters para os campos da classe
public class ProdutoCreateDto {    
    private String nome;  // Campo para o nome do produto
    
    // Instância estática de ModelMapper para conversão entre DTO e entidade
    private static final ModelMapper mapper = new ModelMapper();
    
    // Método para converter o DTO em uma entidade Produto
    public Produto toModel() {
        return mapper.map(this, Produto.class); // Usa o ModelMapper para mapear os campos do DTO para a entidade Produto
    }
}
