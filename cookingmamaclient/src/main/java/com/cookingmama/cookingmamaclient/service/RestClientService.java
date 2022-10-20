package com.cookingmama.cookingmamaclient.service;

import com.cookingmama.cookingmamaclient.dto.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClientService {

    @Autowired
    private RestTemplate restTemplate;

    // tampung semua data resep
    public ResponseEntity<Recipe[]>getAll(){
        ResponseEntity<Recipe[]>response=restTemplate.getForEntity("http://localhost:8080/api/recipe/recipes", Recipe[].class);
        return response;
    }
}
