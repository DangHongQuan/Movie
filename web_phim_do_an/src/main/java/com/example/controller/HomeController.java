package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


import com.example.constants.Api;
import com.example.models.MovieDetail;
import com.example.models.MovieNow;
import com.example.service.MovieService;

import java.lang.String;


@Controller
@RequestMapping("/")
public class HomeController {
	 private final MovieService movieService;
	 public HomeController(MovieService movieService) {
	        this.movieService = movieService;
	    }

@GetMapping
	 public String home(Model model) {
	        try {
	            List<MovieNow> movies = movieService.getNowPlayingMovies(1);
	            model.addAttribute("movies", movies);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
//	    	List<MovieNow> allMovies = new ArrayList<>();
//
//	    	int page = 1;
//	    	while (true) {
//	    	    try {
//	    	        List<MovieNow> movies = movieService.getNowPlayingMovies(page++);
//	    	        if (movies.isEmpty()) {
//	    	            break;
//	    	        }
//	    	        allMovies.addAll(movies);
//	    	    } catch (IOException e) {
//	    	        e.printStackTrace();
//	    	        break;
//	    	    }
//	    	}
//
//	    	model.addAttribute("movies", allMovies);
	        return "users/pages/home";
	    }
@GetMapping("/category")
public String getcategory() {
	
	return "users/pages/category";
}
@GetMapping("/details/{id}")
public String getdetails(@PathVariable Long id,Model model) {
	 try {
	        // Lấy thông tin chi tiết của phim từ API
	        RestTemplate restTemplate = new RestTemplate();
	        String url = "https://api.themoviedb.org/3/movie/" + id + "?api_key=e9e9d8da18ae29fc430845952232787c&language=en-US";
	        Map<String, String> uriVariables = new HashMap<>();
	        uriVariables.put("api_key", "your_api_key");
	        ResponseEntity<MovieDetail> response = restTemplate.exchange(url, HttpMethod.GET, null,
	                new ParameterizedTypeReference<MovieDetail>() {}, uriVariables);
	        MovieDetail movieDetails = response.getBody();

	        // Truyền thông tin chi tiết phim vào model
	        model.addAttribute("movie", movieDetails);
	    } catch (RestClientException e) {
	        e.printStackTrace();
	    }
	    return "users/pages/details";
}



}
