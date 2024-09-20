package com.github.fiap.simple_api_java.repository;

// Importa a interface JpaRepository do Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;

// Importa a entidade Produto
import com.github.fiap.simple_api_java.model.Produto;

/*
 * A função da interface ProdutoRepository é fornecer métodos para 
 * realizar operações de persistência (CRUD - Create, Read, Update, Delete) 
 * na entidade Produto no banco de dados. 
 * Ela estende a interface JpaRepository do Spring Data JPA, 
 * que já fornece uma implementação padrão para essas operações
 */

// Define a interface ProdutoRepository que estende JpaRepository
// JpaRepository fornece métodos CRUD e outras operações para a entidade Produto
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	// A interface não precisa de implementação, pois JpaRepository já fornece as operações básicas
}
