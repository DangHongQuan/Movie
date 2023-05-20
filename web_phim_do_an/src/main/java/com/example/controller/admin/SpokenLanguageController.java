package com.example.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.models.admin.SpokenLanguage;
import com.example.service.admin.SpokenLanguageService;

@Controller
@RequestMapping("/admin/spoken")
public class SpokenLanguageController {
	@Autowired
	private SpokenLanguageService service;
	
	@GetMapping("/add")
	public String getAddSpoken(@ModelAttribute("spoken") SpokenLanguage spoken) {
		return "quanly/pages/spoken/add_spoken";
	}
	
	@PostMapping("/add")
	public String postSpoken(@ModelAttribute SpokenLanguage spokenLanguage) {
		service.insertSpoken(spokenLanguage);
		return "redirect:/admin/spoken/add";
	}
	
	@GetMapping("/list")
	public String getListSpoken() {
		return "";
	}
}
