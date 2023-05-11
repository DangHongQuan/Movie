package com.example.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.models.admin.Movie;
import com.example.service.admin.AdminMovieService;

@Controller
@RequestMapping("/admin")
public class MovieController {


	@Autowired
	private AdminMovieService adminMovieService;
	@GetMapping("/movie")
	public String getaddMovie() {
		return "quanly/pages/movies/add_movie";
	}

	@GetMapping("/addmovietest")
	public String addAuthor(Model model) {
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		return "addmovietest";
	}
	
	@PostMapping("/addmovietest")
	public String savePhoneBook(@ModelAttribute("author") Movie movie) {
		adminMovieService.insertMovies(movie);
		return "redirect:/addmovietest";
	}
}
