package com.perscholas.RestApi_Group4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MovieController {
    @GetMapping
    public String getMoviePage() {
        return "movies";
    }
}
