package com.example.demo.repositories;

import com.example.demo.entities.FilterEntity;
import com.example.demo.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface FilterRepository extends ElasticsearchRepository<FilterEntity, String> {
    Optional<FilterEntity> findByName(String name);
}
