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
    	Movie movie = new Movie(
    			"Trading Places",
    			"1983",
    			"R",
    			"08 Jun 1983",
    			"116 min",
    			"Comedy",
    			"John Landis",
    			"Timothy Harris, Herschel Weingrod",
    			"Eddie Murphy, Dan Aykroyd, Ralph Bellamy",
    			"A snobbish investor and a wily street con artist find their positions reversed as part of a bet by two callous millionaires.",
    			"English",
    			"United States",
    			"Nominated for 1 Oscar. 3 wins & 5 nominations total",
    			"https://m.media-amazon.com/images/M/MV5BYTEzMjBiMzktMjQyMS00YzBhLTgzNWQtNzA0NmEwMTNmMDQ2XkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg",
    			"Rotten Tomatoes :  88%"
    	);
		model.addAttribute("movie", movie);
        return "movieinfo";
    }
}
