package com.cookingmama.cookingmamaclient.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@Controller
public class RecipeController {

    // control content di path home
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("theDate", new java.util.Date());
        return "home";
    }
}
