package com.perscholas.RestApi_Group4.controllers;


import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.perscholas.RestApi_Group4.repository.entities.Movie;

@Controller
@RequestMapping("/movieinfo")
public class MovieResultController {
    @PostMapping
    public String postHandler(Model model, Movie myMovie) {
    	model.addAttribute("myMovie", myMovie);
    	
    	String url = "http://www.omdbapi.com/?t=";
    	url += myMovie.getTitle().replaceAll(" ", "+");
    	url +="&apikey=b79fdda2";
    	
    	RestTemplate restTemplate = new RestTemplate();
    	String movieData = restTemplate.getForObject(url, String.class);
    	
    	JSONObject json = new JSONObject(movieData);
    	myMovie.setYear(json.getString("Year"));
    	myMovie.setRated(json.getString("Rated"));
    	myMovie.setReleased(json.getString("Released"));
    	myMovie.setRuntime(json.getString("Runtime"));
    	myMovie.setGenre(json.getString("Genre"));
    	myMovie.setDirector(json.getString("Director"));
    	myMovie.setWriter(json.getString("Writer"));
    	myMovie.setActors(json.getString("Actors"));
    	myMovie.setPlot(json.getString("Plot"));
    	myMovie.setLanguage(json.getString("Language"));
    	myMovie.setCountry(json.getString("Country"));
    	myMovie.setAwards(json.getString("Awards"));
    	myMovie.setPoster(json.getString("Poster"));
    	
    	myMovie.setRatings("No ratings");
    	
    	for(int i=0; i< json.getJSONArray("Ratings").length(); i++) {
    		JSONObject rating = new JSONObject(json.getJSONArray("Ratings").get(i).toString());
    		if(rating.getString("Source").compareToIgnoreCase("Rotten Tomatoes") == 0) {
    			myMovie.setRatings(rating.getString("Value"));
    		}
    	}
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
