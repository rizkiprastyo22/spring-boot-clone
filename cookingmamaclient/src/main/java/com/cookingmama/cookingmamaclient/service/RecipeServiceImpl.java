package com.cookingmama.cookingmamaclient.service;

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

    // ambil api resep by Id
    @Value("http://localhost:8080/api/recipe/{id}")
    private String idResource;

    @Autowired
    private RestTemplate restTemplate;

    // implementasi dari penampungan data semua resep
    public List<Recipe>findAll(){
        System.out.println(Arrays.stream(restTemplate.getForObject(resource, Recipe[].class)).collect(Collectors.toList()));
        return Arrays.stream(restTemplate.getForObject(resource, Recipe[].class)).collect(Collectors.toList());
    }

    // implementasi dari penampungan data resep by Id
    public Recipe getDetail(Long id){
        return restTemplate.getForObject(idResource, Recipe.class,id);
    }
}
