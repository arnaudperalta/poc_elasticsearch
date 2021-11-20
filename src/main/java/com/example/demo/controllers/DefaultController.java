package com.example.demo.controllers;

import com.example.demo.entities.FilterEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.models.PostFilterDto;
import com.example.demo.services.FilterService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DefaultController
{
    private final UserService userService;

    private final FilterService filterService;

    @Autowired
    public DefaultController(UserService defaultService, FilterService filterService) {
        this.userService = defaultService;
        this.filterService = filterService;
    }

    @PostMapping("/user")
    public String setupUsersAction() {
        userService.setupUsers();
        return "Users in database have been set up.";
    }

    @GetMapping("/user")
    public Iterable<UserEntity> getUsersAction() {
        return userService.getAllUsers();
    }

    @PostMapping("/filter")
    public FilterEntity postFilterAction(@RequestBody PostFilterDto dto) {
        return filterService.createFilter(dto);
    }

    @GetMapping("/filter")
    public Iterable<FilterEntity> getFiltersAction() {
        return filterService.getAllFilters();
    }

    @GetMapping("/filter/user")
    public Iterable<UserEntity> filterUsersAction(@RequestParam("filtername") String filterName) {
        return filterService.filterUsers(filterName);
    }
}
