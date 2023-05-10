package com.example.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class MovieController {
@GetMapping("/movie")
public String getaddMovie() {
	return "quanly/pages/movies/add_movie";
}
}
