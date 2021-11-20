package com.example.demo.entities;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Data
@Document(indexName = "user")
public class UserEntity {
    @Id
    private String id;

    private String firstname;

    private String lastname;
}
