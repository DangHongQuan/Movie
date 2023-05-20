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
		return "redirect:/admin/spoken/list";
	}
	
	@GetMapping("/list")
	public String getListSpoken(Model model) {
		List<SpokenLanguage> spoken = service.findMany();
		model.addAttribute("spoken", spoken);
		return "quanly/pages/spoken/list";
	}
	
	@GetMapping("/edit/{id}")
	public String getEditSpo(@PathVariable("id") Integer spoId, Model model) {
		SpokenLanguage spoken = service.findOne(spoId);
		model.addAttribute("spoken", spoken);
		return "quanly/pages/spoken/edit";
	}
	
	@PostMapping("/edit")
	public String postEditSpo(@ModelAttribute("spoken") SpokenLanguage spoken) {
		service.updateSpolang(spoken);
		return "redirect:/admin/spoken/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteSpoken(@PathVariable("id") Integer id) {
		service.deleteSpolang(id);
		return "redirect:/admin/spoken/list";
	}
}
