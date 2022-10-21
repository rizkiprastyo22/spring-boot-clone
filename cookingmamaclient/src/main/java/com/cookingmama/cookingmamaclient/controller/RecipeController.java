package com.cookingmama.cookingmamaclient.controller;

import com.cookingmama.cookingmamaclient.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@Controller
public class RecipeController {

    @Autowired
    private RecipeService service;

    // control content di path home
    @GetMapping("/home")
    public String home(Model model){
//        model.addAttribute("theDate", new java.util.Date());
        model.addAttribute("recipes", service.findAll());
        return "home";
    }

    // control content di path detail
    @GetMapping("/detail/{id}")
    public String getRecipesId (@PathVariable Long id, String name, Model model){
        model.addAttribute("detail", service.getDetail(id));
        return "detailRecipe";
    }

    @Bean
    public RecipeService service(){
        return new RecipeService();
    }
}
