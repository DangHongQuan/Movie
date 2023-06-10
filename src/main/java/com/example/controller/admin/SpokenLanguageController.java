package com.example.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.models.admin.Movie;
import com.example.models.admin.Moviespokenlanguages;
import com.example.models.admin.Movievideo;
import com.example.models.admin.SpokenLanguage;
import com.example.service.MovieService;
import com.example.service.admin.Movie.AdminMovieService;
import com.example.service.admin.Moviespokenlanguages.AdminMoviespokenlanguagesService;
import com.example.service.admin.SpokeLanguage.SpokenLanguageService;

@Controller
@RequestMapping("/admin/spoken")
public class SpokenLanguageController {

	private final SpokenLanguageService languageService;

	    @Autowired
	    public SpokenLanguageController(SpokenLanguageService languageService) {
	        this.languageService = languageService;
	    }
	@Autowired
	private SpokenLanguageService service;

	@Autowired
    private AdminMovieService adminMovieService;
	
	@Autowired
	private AdminMoviespokenlanguagesService adminMoviespokenlanguagesService;
	@GetMapping("/add")
	public String getAddSpoken(@ModelAttribute("spoken") SpokenLanguage spoken, Model model,@ModelAttribute("movieSpokeLa") Moviespokenlanguages moviespokenlanguages) {
		List<Movie> listmovieSpoke= adminMovieService.listMovie();
		model.addAttribute("listMovieSpoke", listmovieSpoke);
		Moviespokenlanguages movieSpokeLa=new Moviespokenlanguages();
		model.addAttribute("movieSpokeLa", movieSpokeLa);

		return "quanly/pages/spoken/add_spoken";
	}
	
	@PostMapping("/add")
	public String postSpoken(@ModelAttribute SpokenLanguage spokenLanguage,@ModelAttribute Moviespokenlanguages moviespokenlanguages) {
		// service.insertMovieVideo(movievideo);
		// service.insertSpoken(spokenLanguage);
		Integer soplangId= languageService.insertMovieVideoWithSpokeLa(spokenLanguage,moviespokenlanguages);
		return "redirect:/admin/spoken/add";
	}
	
	@GetMapping("/list")
	public String getListSpoken(Model model) {
		List<SpokenLanguage> spoken = service.findMany();
		model.addAttribute("spoken", spoken);
		return "quanly/pages/spoken/list";
	}
	
	@GetMapping("/editspoken/{id}")
	public String getEditSpo(@PathVariable("id") Integer spoId, Model model) {
		SpokenLanguage spoken = service.findOne(spoId);
		model.addAttribute("spoken", spoken);
		List<Movie> movies = adminMovieService.listMovie();
		model.addAttribute("listMovie", movies);
		Moviespokenlanguages moviespokenlanguages = new Moviespokenlanguages();
		model.addAttribute("moviespokenlanguages", moviespokenlanguages);
		return "quanly/pages/spoken/edit";
	}
	
	@PostMapping("/editspoken")
	public String postEditSpo(@ModelAttribute("spoken") SpokenLanguage spoken,@ModelAttribute("MovieSpoke") Moviespokenlanguages moviespokenlanguages) {

		Integer msId = spoken.getSpolangId();
		moviespokenlanguages.setMslId(msId);
		moviespokenlanguages.setSpolangId(msId);
		service.updateSpolang(spoken);
		adminMoviespokenlanguagesService.updateMovieSpoke(moviespokenlanguages);
		return "redirect:/admin/spoken/list";
	}



	@GetMapping("/deletespoke/{id}")
	public String deleteSpoken(@PathVariable("id") Integer id) {
		service.deleteSpolang(id);
		return "redirect:/admin/spoken/list";
	}
}
