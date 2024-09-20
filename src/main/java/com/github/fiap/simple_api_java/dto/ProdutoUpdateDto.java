package com.github.fiap.simple_api_java.dto;

import org.modelmapper.ModelMapper;

import com.github.fiap.simple_api_java.model.Produto;

import lombok.Getter;
import lombok.Setter;

/*
 * A classe ProdutoUpdateDto é um Data Transfer Object (DTO) 
 * usado para transferir dados de atualização de um produto entre a 
 * camada de apresentação (como um controlador REST) e a camada de serviço. 
 * Ele contém os dados necessários para atualizar um produto existente e fornece um método 
 * para converter esses dados em uma entidade Produto.
 */
@Getter // Gera automaticamente os métodos getters para os campos da classe
@Setter // Gera automaticamente os métodos setters para os campos da classe
public class ProdutoUpdateDto {
    private long id; // Campo para o ID do produto
    private String nome;  // Campo para o nome do produto
    
    // Instância estática de ModelMapper para conversão entre DTO e entidade
    private static final ModelMapper mapper = new ModelMapper();
    
    // Método para converter o DTO em uma entidade Produto
    public Produto toModel() {
        return mapper.map(this, Produto.class); // Usa o ModelMapper para mapear os campos do DTO para a entidade Produto
    }
}
