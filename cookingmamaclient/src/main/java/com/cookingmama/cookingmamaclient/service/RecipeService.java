package com.cookingmama.cookingmamaclient.service;

import com.cookingmama.cookingmamaclient.dto.RecipeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    // ambil api semua resep
    @Value("${resource.recipes}")
    private String resource;

    // ambil api resep by Id
    @Value("${resource.getId}/{id}")
    private String idResource;

    // ambil api create resep
    @Value("${resource.create}")
    private String createResource;

    // ambil api update untuk edit
    @Value("${resource.edit}")
    private String editResource;

    @Autowired
    private RestTemplate restTemplate;

    // pemrosesan dari data yang ditampung di penampungan data semua resep
    public List<RecipeDTO>getAllRecipes(){
        System.out.println(Arrays.stream(restTemplate.getForObject(resource, RecipeDTO[].class)).collect(Collectors.toList()));
        return Arrays.stream(restTemplate.getForObject(resource, RecipeDTO[].class)).collect(Collectors.toList());
    }

    // pemrosesan dari data yang ditampung di penampungan data resep by Id
    public RecipeDTO getDetailRecipe(Long id){
        return restTemplate.getForObject(idResource, RecipeDTO.class,id);
    }

    // implementasi dari pembuatan resep baru
    public RecipeDTO createRecipe(RecipeDTO recipe){
        return restTemplate.postForObject(createResource, recipe, RecipeDTO.class);
    }

    public RecipeDTO editRecipe(Long id, RecipeDTO recipe){
        return restTemplate.postForObject(editResource+"/"+id, recipe, RecipeDTO.class);
    }
}
