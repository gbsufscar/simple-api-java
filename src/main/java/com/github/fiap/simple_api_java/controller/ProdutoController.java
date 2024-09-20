package com.github.fiap.simple_api_java.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.fiap.simple_api_java.dto.ProdutoCreateDto;
import com.github.fiap.simple_api_java.dto.ProdutoResponseDto;
import com.github.fiap.simple_api_java.dto.ProdutoUpdateDto;
import com.github.fiap.simple_api_java.model.Produto;
import com.github.fiap.simple_api_java.service.ProdutoService;

import lombok.RequiredArgsConstructor;

/*
 * A classe ProdutoController é um controlador REST do Spring que gerencia as operações relacionadas à entidade Produto. 
 * Ela define endpoints para listar, buscar, criar e atualizar produtos. 
 * Utiliza o serviço ProdutoService para realizar as operações de negócio e 
 * converte os modelos de produto para DTOs (Data Transfer Objects) para serem retornados 
 * nas respostas HTTP.
 */

@RestController // Indica que esta classe é um controlador REST do Spring
@RequestMapping("/produtos") // Define o mapeamento de URL base para este controlador
@RequiredArgsConstructor // Gera um construtor com todos os campos finais (final)
public class ProdutoController {
    private final ProdutoService produtoService; // Injeção de dependência do serviço de produtos
    
    // Método para listar todos os produtos
    @GetMapping // Define o mapeamento de URL para a listagem de produtos
    public ResponseEntity<List<ProdutoResponseDto>> list() {
        // Obtém a lista de produtos do serviço, converte cada produto em um DTO e retorna a lista de DTOs na resposta HTTP
        List<ProdutoResponseDto> responseDtos = produtoService.list()
            .stream() // Converte a lista de produtos em uma stream
            .map(produto -> new ProdutoResponseDto().toDto(produto)) // Mapeia cada produto para um DTO
            .toList(); // Converte a stream de DTOs de volta para uma lista
        return ResponseEntity.ok().body(responseDtos); // Retorna a lista de DTOs na resposta HTTP com status 200 OK. Body é o corpo da resposta.
    }

    // Método para encontrar um produto pelo ID
    @GetMapping("{id}") // Define o mapeamento de URL para buscar um produto pelo ID
    public ResponseEntity<ProdutoResponseDto> findById(@PathVariable Long id) {
        // Busca o produto pelo ID, converte o produto em um DTO e retorna o DTO na resposta HTTP
        ProdutoResponseDto responseDto = produtoService
                .findById(id)
                .map(produto -> new ProdutoResponseDto().toDto(produto))
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

                return ResponseEntity.ok().body(responseDto); // Retorna o DTO na resposta HTTP com status 200 OK
    }

    // Método para criar um novo produto
    @PostMapping
    public ResponseEntity<ProdutoResponseDto> create(@RequestBody ProdutoCreateDto requestDto) {
        // Salva o novo produto no banco de dados
        Produto produto = produtoService.saveOrUpdate(requestDto.toModel());
        // Converte o produto salvo para um DTO de resposta
        ProdutoResponseDto responseDto = new ProdutoResponseDto().toDto(produto);
        return ResponseEntity.ok().body(responseDto); // Retorna o DTO de resposta na resposta HTTP com status 200 OK
    }

    // Método para atualizar um produto existente
    @PutMapping("{id}")
    public ResponseEntity<ProdutoResponseDto> update(@PathVariable Long id, @RequestBody ProdutoUpdateDto requestDto) {
        // Verifica se o produto com o ID especificado existe
        if (! produtoService.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
        }
        // Atualiza o produto com o ID especificado 
        Produto produto = produtoService.saveOrUpdate(requestDto.toModel());
        // Converte o produto atualizado para um DTO de resposta
        ProdutoResponseDto responseDto = new ProdutoResponseDto().toDto(produto);
        return ResponseEntity.ok().body(responseDto); // Retorna o DTO de resposta na resposta HTTP com status 200 OK
    }

    // Método para deletar um produto pelo ID
    @DeleteMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id) { // O método não retorna um corpo na resposta
        // Verifica se o produto com o ID especificado existe
        if (!produtoService.existsById(id)) {
            new RuntimeException("Deu merda"); // Se não existir, lança uma exceção
        }  
        // Deleta o produto com o ID especificado
        produtoService.delete(id);
        return ResponseEntity.ok().build(); // Retorna uma resposta HTTP com status 200 OK e sem corpo
    }

}
