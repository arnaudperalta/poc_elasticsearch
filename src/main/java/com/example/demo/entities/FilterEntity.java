package com.example.demo.entities;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

// Filtre ne supportant que l'opération d'égalité avec les String sur l'entité UserEntity.
@Data
@Document(indexName = "filter")
public class FilterEntity {
    @Id
    private String id;

    private String name;

    private String expression; // Contient le filtre ElasticSearch
}
