package com.example.controller.Api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.models.MovieDetail;
import com.example.models.MovieNow;
import com.example.models.Video;

import com.example.models.admin.Movie;
import com.example.service.MovieService;
import com.example.service.admin.Genres.AdminGenresService;
import com.example.service.admin.Movie.AdminMovieService;
import com.example.service.admin.MovieGenre.AdminMoveiGenreService;
import com.example.service.admin.Video.VideoService;

@Controller
public class PlayMovieController {
	 private final MovieService movieService;
	 public PlayMovieController(MovieService movieService,AdminMovieService adminMovieService,VideoService service) {
	        this.movieService = movieService;
	        this.adminMovieService = adminMovieService;
	        this.service = service;
	    }

//	 Phần Dữ liệu lấy từ database
	 @Autowired
		private AdminMoveiGenreService adminMoveiGenreService;
		  private final AdminMovieService adminMovieService;
		  private final VideoService service;
		@Autowired
		private AdminGenresService adminGenresService;
	 
//	 Kết thúc phần dữ liệu tạo từ database    
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
		 List<Movie> movies = adminMovieService.listMovie(); 
			model.addAttribute("moviess", movies);
			
			try {
	            List<MovieNow> moviesss = movieService.getNowPlayingMovies(1);
	            model.addAttribute("moviesss", moviesss);
	           
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		return "users/pages/playmovie";
	}
	@GetMapping("/playmovie2/{movieId}")
	public String getplay(@PathVariable Integer movieId , Model model) {
		try {
			// Lấy thông tin movie từ database dựa trên movieId
		    Movie movie = adminMovieService.findMovieId(movieId);
		    if (movie == null) {
		        // Xử lý khi không tìm thấy movie
		        return "error-page";
		    }
		    
		
		    // Lấy danh sách video dựa trên movieId
		    List<com.example.models.admin.Video> videos = service.findVideoByMovieId(movieId);
		    if (videos.isEmpty()) {
		        // Xử lý khi không tìm thấy video
		        return "error-page";
		    }
		    
		    // Chọn một video để hiển thị (ví dụ: video đầu tiên)
		    com.example.models.admin.Video video = videos.get(0);
		    // Đưa thông tin movie và video vào model để truyền cho view
		    model.addAttribute("movie", movie);
		    model.addAttribute("video", video);
		    List<Movie> movies = adminMovieService.listMovie(); 
				model.addAttribute("movies", movies);
		}catch (RestClientException e) {
	        e.printStackTrace();
	    } 
		   try {
	            List<MovieNow> moviess = movieService.getNowPlayingMovies(1);
	            model.addAttribute("moviess", moviess);
	           
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		return "users/pages/playmovie2";
	}
}
