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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.FileSystemUtils;

import com.example.models.Genre;
import com.example.models.admin.Movie;
import com.example.service.admin.AdminGenresService;
import com.example.service.admin.AdminMovieService;



@Controller
@RequestMapping("/admin")
public class MovieController {

	@Autowired
	private AdminGenresService adminGenresService;

	@Autowired
	private AdminMovieService adminMovieService;
	// @GetMapping("/movie")
	// public String getaddMovie() {
	// 	return "quanly/pages/movies/add_movie";
	// }

	@GetMapping("/adminmovie")
	public String addAuthor(Model model) {
		List<Genre> genresList = adminGenresService.getAllGenre();
		model.addAttribute("genresList", genresList);
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		return "quanly/pages/movies/add_movie";
	}
	
	@PostMapping("/adminmovie")
	public String savePhoneBook(@ModelAttribute("movie") Movie movie) {
		adminMovieService.insertMovies(movie);
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
		return "quanly/pages/movies/edit_movie";
	}

	@PostMapping(value = "/update")
	public String updateMovie(@ModelAttribute("udMovie") Movie movie){
		adminMovieService.updateMovie(movie);
		return "redirect:/admin/listmovie";

	}



	
	

}
