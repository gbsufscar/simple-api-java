package com.github.fiap.simple_api_java.model;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/*
 * Uma entidade JPA (Java Persistence API) é uma classe Java que representa uma tabela no banco de dados. 
 * Cada instância da entidade corresponde a uma linha na tabela. 
 * As entidades JPA são usadas para mapear objetos Java para registros de banco de dados, 
 * facilitando a manipulação de dados de forma orientada a objetos.

 * Essa classe facilita a reutilização de código, permitindo que outras entidades herdem o 
 * identificador genérico e suas funcionalidades.
 */

// Classe abstrata que representa uma entidade genérica
@MappedSuperclass // Indica que a classe não é uma entidade, mas que suas propriedades devem ser mapeadas para as entidades filhas
public abstract class AbstractEntity<ID> implements Serializable {

	@Id // Identifica a chave primária
	@GeneratedValue(strategy = GenerationType.AUTO) // Gera automaticamente o valor da chave primária
	private ID id;

	// Getters e Setters
	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

}
