package com.example.controller.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.FileSystemUtils;


import com.example.models.admin.Movie;
import com.example.service.admin.AdminMovieService;

import ch.qos.logback.core.util.FileUtil;

@Controller
@RequestMapping("/admin")
public class MovieController {


	@Autowired
	private AdminMovieService adminMovieService;
	// @GetMapping("/movie")
	// public String getaddMovie() {
	// 	return "quanly/pages/movies/add_movie";
	// }

	@GetMapping("/adminmovie")
	public String addAuthor(Model model) {
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		return "quanly/pages/movies/add_movie";
	}
	
	@PostMapping("/adminmovie")
	public String savePhoneBook(@ModelAttribute("author") Movie movie) {
		adminMovieService.insertMovies(movie);
		return "redirect:/admin/adminmovie";
	}



	
	

}
