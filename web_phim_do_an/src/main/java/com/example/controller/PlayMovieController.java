package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.models.MovieDetail;
import com.example.models.Video;
import com.example.service.MovieService;

@Controller
public class PlayMovieController {
	 private final MovieService movieService;
	 public PlayMovieController(MovieService movieService) {
	        this.movieService = movieService;
	    }

	
	
	    
	    private final String API_KEY = "e9e9d8da18ae29fc430845952232787c";
	    private final String API_URL = "https://api.themoviedb.org/3/movie/";
	@GetMapping("/playmovie/{id}")
	public String getplay(@PathVariable Long id , Model model) {
		try {
			  // Lấy thông tin chi tiết của phim từ API
	        RestTemplate restTemplate = new RestTemplate();
	        String url = API_URL + id + "?api_key=" + API_KEY + "&append_to_response=videos";
	        
	        MovieDetail movieDetail = restTemplate.getForObject(url, MovieDetail.class);
	        // Truyền danh sách video vào model
	        List<Video> videos = movieDetail.getVideos().getResults();
	        model.addAttribute("videos", videos);
	        // Truyền thông tin chi tiết phim vào model
	        model.addAttribute("movie", movieDetail);
	     
		}catch (RestClientException e) {
	        e.printStackTrace();
	    }   
		return "users/pages/playmovie";
	}
}
