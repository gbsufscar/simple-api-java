package com.github.fiap.simple_api_java.dto;

import org.modelmapper.ModelMapper;

import com.github.fiap.simple_api_java.model.Produto;

import lombok.Getter;
import lombok.Setter;

/*
 * A classe ProdutoResponseDto é um Data Transfer Object (DTO) 
 * usado para transferir dados de resposta de um produto entre a camada de serviço e a 
 * camada de apresentação (como um controlador REST). 
 * Ele contém os dados que serão retornados ao cliente e fornece um método para 
 * converter uma entidade Produto em um ProdutoResponseDto.
 */
@Getter // Gera automaticamente os métodos getters para os campos da classe
@Setter // Gera automaticamente os métodos setters para os campos da classe
public class ProdutoResponseDto {
    private Long id; // Campo para o ID do produto
    private String nome;  // Campo para o nome do produto
    
    // Instância estática de ModelMapper para conversão entre entidade e DTO
    private static final ModelMapper mapper = new ModelMapper();
    
    // Método para converter uma entidade Produto em um ProdutoResponseDto
    public ProdutoResponseDto toDto(Produto produto) {
        return mapper.map(produto, ProdutoResponseDto.class); // Usa o ModelMapper para mapear os campos da entidade Produto para o DTO
    }
}
