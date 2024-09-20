package com.github.fiap.simple_api_java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.fiap.simple_api_java.model.Produto;
import com.github.fiap.simple_api_java.repository.ProdutoRepository;

import lombok.RequiredArgsConstructor;



/*
 * A função deste código é definir um serviço Spring chamado ProdutoService, 
 * que gerencia operações relacionadas à entidade Produto. 
 * Este serviço utiliza um repositório (ProdutoRepository) para 
 * realizar operações de persistência no banco de dados, como criar, ler, 
 * atualizar e deletar produtos.

 * O ProdutoService é responsável por encapsular a lógica de negócios 
 * relacionada à entidade Produto e interagir com o repositório 
 * ProdutoRepository para realizar operações de persistência no banco de dados. 
 * Ele fornece métodos para listar, salvar, atualizar, deletar e 
 * verificar a existência de produtos.
 */
@Service // Indica que esta classe é um serviço do Spring
@RequiredArgsConstructor // Gera um construtor com todos os campos finais (final)
public class ProdutoService {
    // Injeção de dependência do repositório de produtos
    private final ProdutoRepository produtoRepository; // Repositório de produtos para acesso ao banco de dados

    // Método para listar todos os produtos
    public List<Produto> list() {
        return produtoRepository.findAll(); // Chama o método findAll do repositório para listar todos os produtos
    }

    // Método para salvar ou atualizar um produto
    public Produto saveOrUpdate(Produto produto) {
        return produtoRepository.save(produto); // Salva ou atualiza o produto no banco de dados
    }
    
    // Método para deletar um produto pelo ID
    public void delete(long id) {
        produtoRepository.deleteById(id); // Deleta o produto com o ID especificado
    }

    // Método para encontrar um produto pelo ID
    public Optional<Produto> findById(long id) {
        return produtoRepository.findById(id); // Retorna o produto com o ID especificado, se existir
    }
    
    // Método para verificar se um produto existe pelo ID
    public boolean existsById(long id) {
        return produtoRepository.existsById(id); // Retorna true se o produto com o ID especificado existir
    }
}