package com.github.fiap.simple_api_java.model;

// Importações necessárias para anotações JPA e Lombok
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/*
 * Essa classe define a entidade Produto, que será mapeada para a tabela 
 * produtos no banco de dados, com um campo nome que possui restrições específicas.
 */

@Entity // Marca a classe como uma entidade JPA
@Table(name = "produtos") // Especifica o nome da tabela no banco de dados
@Getter // Gera automaticamente os métodos getters e setters
@Setter
@EqualsAndHashCode(callSuper=false) // Gera automaticamente os métodos equals e hashCode, sem considerar os campos da superclasse
public class Produto extends AbstractEntity<Long> { // Define a classe Produto que estende AbstractEntity com um identificador do tipo Long
    @Column(nullable = false, length = 50, unique = true) // Define a coluna 'nome' na tabela 'produtos' com restrições específicas
    private String nome;
}