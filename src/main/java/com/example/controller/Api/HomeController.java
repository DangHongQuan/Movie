package com.example.controller.Api;

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
import com.example.models.Genre;
import com.example.models.MovieDetail;
import com.example.models.MovieNow;
import com.example.models.admin.Movie;
import com.example.models.admin.MovieGenre;
import com.example.service.MovieService;
import com.example.service.admin.Genres.AdminGenresService;
import com.example.service.admin.Movie.AdminMovieService;
import com.example.service.admin.MovieGenre.AdminMoveiGenreService;

import java.lang.String;


@Controller
@RequestMapping("/")
public class HomeController {
	 private final MovieService movieService;
	 public HomeController(MovieService movieService,AdminMovieService adminMovieService) {
	        this.movieService = movieService;
	        this.adminMovieService = adminMovieService;
	    }
	 
//	 Phần Dữ liệu lấy từ database
	 @Autowired
		private AdminMoveiGenreService adminMoveiGenreService;
		  private final AdminMovieService adminMovieService;
		          
		@Autowired
		private AdminGenresService adminGenresService;
	 
//	 Kết thúc phần dữ liệu tạo từ database

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
	        List<Genre> genresList = adminGenresService.getAllGenre();
    		model.addAttribute("genresList", genresList);
    		List<Movie> movie = adminMovieService.listMovie(); 
    		model.addAttribute("movie", movie);
    		MovieGenre movieGenres = new MovieGenre();
    		model.addAttribute("movieGenres", movieGenres);
	        return "users/pages/home";
	    }
@GetMapping("/category")
public String getcategory() {
	
	return "users/pages/category";
}
@GetMapping("/details/{id}")
public String getdetails(@PathVariable Long id,Model model) {
	 try {
         List<MovieNow> movies = movieService.getNowPlayingMovies(1);
         model.addAttribute("movies", movies);
        
     } catch (IOException e) {
         e.printStackTrace();
     }
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
	 List<Movie> moviess = adminMovieService.listMovie(); 
		model.addAttribute("moviess", moviess);
	    return "users/pages/details";
}
@GetMapping("/details2/{movieId}")
public String getdetails2(@PathVariable Integer movieId,Model model) {
	 try {
	        // Lấy thông tin chi tiết của phim từ API
		 List<Movie> movies = adminMovieService.listMovie(); 
		 Movie movie = adminMovieService.findMovieId(movieId);
			model.addAttribute("movie", movie);
			model.addAttribute("movies", movies);
			List<Genre> listGenreEdit = adminGenresService.getAllGenre();
			model.addAttribute("listGenreEdit", listGenreEdit);
			MovieGenre movieGenres = new MovieGenre();
			model.addAttribute("movieGenresedit", movieGenres);
	        // Truyền thông tin chi tiết phim vào model
//	        model.addAttribute("movie", movieDetails);
	    } catch (RestClientException e) {
	        e.printStackTrace();
	    }
//	 try {
//         List<MovieNow> moviesss = movieService.getNowPlayingMovies(1);
//         model.addAttribute("moviesss", moviesss);
//        
//     } catch (IOException e) {
//         e.printStackTrace();
//     }
	    return "users/pages/details2";
}


}
