package com.example.demo.services;

import com.example.demo.entities.FilterEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.models.PostFilterDto;
import com.example.demo.repositories.FilterRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilterService {

    private final FilterRepository filterRepo;

    private final UserRepository userRepo;

    @Autowired
    public FilterService(FilterRepository filterRepo, UserRepository userRepo) {
        this.filterRepo = filterRepo;
        this.userRepo = userRepo;
    }

    public FilterEntity createFilter(PostFilterDto dto) {
        FilterEntity filter = new FilterEntity();
        filter.setName(dto.getName());
        filter.setExpression(buildElasticFilter(dto.getFieldName(), dto.getValue()));
        return filterRepo.save(filter);
    }

    public Iterable<FilterEntity> getAllFilters() {
        return filterRepo.findAll();
    }

    public Iterable<UserEntity> filterUsers(String filterName) {
        Optional<FilterEntity> filter = filterRepo.findByName(filterName);
        if (filter.isEmpty())
            throw new IllegalArgumentException("Invalid filter name");
        return userRepo.findWithFilter(filter.get().getExpression());
    }

    private String buildElasticFilter(String fieldName, String value) {
        // À ne pas reproduire
        return "{\"match\": {\"" + fieldName + "\": \"" + value + "\"}}";
    }
}
