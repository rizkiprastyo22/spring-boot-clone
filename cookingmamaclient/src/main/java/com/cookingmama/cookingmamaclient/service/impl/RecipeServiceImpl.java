package com.cookingmama.cookingmamaclient.service.impl;

import com.cookingmama.cookingmamaclient.dto.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl {

    // ambil api semua resep
    @Value("http://localhost:8080/api/recipe/recipes")
    private String resource;

    @Autowired
    private RestTemplate restTemplate;

    // implementasi dari penampungan data
    public List<Recipe>findAll(){
        System.out.println(Arrays.stream(restTemplate.getForObject(resource, Recipe[].class)).collect(Collectors.toList()));
        return Arrays.stream(restTemplate.getForObject(resource, Recipe[].class)).collect(Collectors.toList());
    }
}
