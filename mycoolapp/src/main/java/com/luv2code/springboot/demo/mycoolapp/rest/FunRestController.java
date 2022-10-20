package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    // inject the properties
    @Value("${coach.name}")
    private String coachName;

    @Value("${coach.team}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: " + coachName + ", Team Name: " + teamName;
    }

    // expose "/" return Hello world
    @GetMapping("/")
    public String sayHello(){
        return "Hello World! Time in server is " + LocalDateTime.now();
    }

    // expose a new endpoint "workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "haha you a hard 5k!";
    }

}
