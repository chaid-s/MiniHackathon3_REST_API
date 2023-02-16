package com.perscholas.RestApi_Group4.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieinfo")
public class MovieResultController {
    @PostMapping
    public String postHandler(Model model) {
        return "movieinfo";
    }

    //exists if somebody navigates directly
    @GetMapping
    public String getHandler(Model model){
        return "movieinfo";
    }
}
