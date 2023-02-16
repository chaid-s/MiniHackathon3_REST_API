package com.perscholas.RestApi_Group4.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.perscholas.RestApi_Group4.repository.entities.Movie;

@Controller
@RequestMapping("/movieinfo")
public class MovieResultController {
    @PostMapping
    public String postHandler(Model model) {
    	model.addAttribute("myMovie", new Movie());
        return "movieinfo";
    }

    //exists if somebody navigates directly
    @GetMapping
    public String getHandler(Model model){
        return "movieinfo";
    }
}
