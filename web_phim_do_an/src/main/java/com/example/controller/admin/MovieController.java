package com.example.controller.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.FileSystemUtils;

import com.example.models.Genre;
import com.example.models.admin.Genres;
import com.example.models.admin.Movie;
import com.example.models.admin.MovieGenre;
import com.example.service.admin.Genres.AdminGenresService;
import com.example.service.admin.Movie.AdminMovieService;
import com.example.service.admin.MovieGenre.AdminMoveiGenreService;




@Controller
@RequestMapping("/admin")
public class MovieController {

	@Autowired
	private AdminMoveiGenreService adminMoveiGenreService;
	  private final AdminMovieService adminMovieService;

	    @Autowired
	    public MovieController(AdminMovieService adminMovieService) {
	        this.adminMovieService = adminMovieService;
	    }
	@Autowired
	private AdminGenresService adminGenresService;



	@GetMapping("/adminmovie")
	public String addAuthor(Model model) {
		List<Genre> genresList = adminGenresService.getAllGenre();
		model.addAttribute("genresList", genresList);
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		MovieGenre movieGenres = new MovieGenre();
		model.addAttribute("movieGenres", movieGenres);
		
		return "quanly/pages/movies/add_movie";
	}
	
	@PostMapping("/adminmovie")
	public String savePhoneBook(@ModelAttribute Movie movie, @ModelAttribute MovieGenre movieGenre) {
		 Integer movieId = adminMovieService.insertMovieWithGenre(movie, movieGenre);
	        // ... Xử lý thành công và trả về thông báo
//		adminMovieService.insertMovies(movie);
//		adminMovieGenreService.insertMovieGenres(movieGenre);
//		adminMovieService.insertMovieGenres(movieGenre);
		return "redirect:/admin/adminmovie";
	}


	@GetMapping("/listmovie")
	public String getAllListMovie(Model model) {
		List<Movie> movies = adminMovieService.listMovie();
		model.addAttribute("movie", movies);
		return "quanly/pages/movies/list_movie";
	}

	@GetMapping(value = "delete/{id}")
	public String deleteMovie(@PathVariable("id") Integer id, Model model) {
		adminMovieService.deleteMovie(id);
		return "redirect:/admin/listmovie";
	}

	@GetMapping(value = "edit/{id}")
	public String editMovie(@PathVariable("id") Integer id, Model model){
		Movie movie = adminMovieService.findMovieId(id);
		model.addAttribute("movie", movie);
		List<Genre> listGenreEdit = adminGenresService.getAllGenre();
		model.addAttribute("listGenreEdit", listGenreEdit);
		MovieGenre movieGenres = new MovieGenre();
		model.addAttribute("movieGenresedit", movieGenres);
		return "quanly/pages/movies/edit_movie";
	}

	@PostMapping(value = "/update")
	public String updateMovie(@ModelAttribute("udMovie") Movie movie,@ModelAttribute("ubMovieGenre") MovieGenre movieGenre, Model model){
		adminMovieService.updateMovie(movie);
		// adminGenresService.insertGenre(genre);
		adminMoveiGenreService.updateMoveiGenreEdit(movieGenre);
		return "redirect:/admin/listmovie";

	}



	
	

}
