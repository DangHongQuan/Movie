package com.example.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.models.Genre;
import com.example.service.admin.AdminGenresService;


@Controller
@RequestMapping(value = "/admin")
public class GenresController {
    
    @Autowired
    private AdminGenresService adminGenresService;

    @GetMapping("/admingenre")
    public String addGenre(Model model) {
        Genre genre = new Genre();
        model.addAttribute("genre", genre);
        return "quanly/pages/genres/add_genres";
    }

    @PostMapping(value = "/admingenre")
    public String addGenre(@ModelAttribute Genre genre) {
    adminGenresService.insertGenre(genre);
    return "redirect:/admin/admingenre";
    }

    


}
