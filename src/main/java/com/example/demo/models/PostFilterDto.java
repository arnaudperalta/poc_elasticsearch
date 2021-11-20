package com.example.demo.models;

import lombok.Data;

@Data
public class PostFilterDto {
    private String name;
    private String fieldName;
    private String value;
}
