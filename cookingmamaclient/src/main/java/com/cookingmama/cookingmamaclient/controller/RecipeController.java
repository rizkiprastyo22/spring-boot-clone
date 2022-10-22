package com.cookingmama.cookingmamaclient.controller;

import com.cookingmama.cookingmamaclient.dto.RecipeDTO;
import com.cookingmama.cookingmamaclient.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@Controller
public class RecipeController {

    @Autowired
    private RecipeService service;

    // control content di path home
    @GetMapping("/home")
    public String home(Model model){
//        model.addAttribute("theDate", new java.util.Date());
        model.addAttribute("recipes", service.getAllRecipes());
        return "home";
    }

    // control content di path detail
    @GetMapping("/detailRecipe/{id}")
    public String getRecipesId (@PathVariable Long id, String name, Model model){
        model.addAttribute("detailRecipe", service.getDetailRecipe(id));
        return "detailRecipe";
    }

    // pindah ke halaman membuat resep baru
    @GetMapping("/createRecipe")
    public String newRecipe(Model model){
        model.addAttribute("newRecipe", new RecipeDTO());
        return "createRecipe";
    }


    // post hasil resep baru
    @PostMapping(value = "/createRecipe/save")
    public String createRecipe(@Validated @ModelAttribute("newRecipe") RecipeDTO recipe){
        service.createRecipe(recipe);
        return "redirect:/home";
    }

    @Bean
    public RecipeService service(){
        return new RecipeService();
    }
}
