package com.perscholas.RestApi_Group4.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MovieController {
    @GetMapping
    public String getMoviePage() {
        return "movies";
    }
}
