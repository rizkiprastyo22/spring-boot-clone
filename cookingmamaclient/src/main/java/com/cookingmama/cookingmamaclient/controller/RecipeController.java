package com.cookingmama.cookingmamaclient.controller;

import com.cookingmama.cookingmamaclient.service.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@Controller
public class RecipeController {

    @Autowired
    private RecipeServiceImpl service;

    // control content di path home
    @GetMapping("/home")
    public String home(Model model){
//        model.addAttribute("theDate", new java.util.Date());
        model.addAttribute("recipes", service.findAll());
        return "home";
    }

    @GetMapping("/detail/{id}")
    public String getRecipesId (@PathVariable Long id, String name, Model model){
        model.addAttribute("detail", service.getDetail(id));
        return "detailRecipe";
    }
}
