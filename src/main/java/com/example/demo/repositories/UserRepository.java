package com.example.demo.repositories;

import com.example.demo.entities.UserEntity;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<UserEntity, String> {
    @Query("?0")
    Iterable<UserEntity> findWithFilter(String query);
}
