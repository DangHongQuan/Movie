package com.example.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.models.Genre;
import com.example.service.admin.Genres.AdminGenresService;
import com.example.service.admin.MovieGenre.AdminMoveiGenreService;

@Controller
@RequestMapping(value = "/admin")
public class GenresController {

    @Autowired
    private AdminGenresService adminGenresService;

    @Autowired
    private AdminMoveiGenreService adminMoveiGenreService;

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

    @GetMapping("/listGenre")
    public String getListGenres(Model model) {

        List<Genre> listGenres = adminGenresService.getAllGenre();
        model.addAttribute("listGenres", listGenres);
        return "quanly/pages/genres/list_Genre";
    }

    // @GetMapping("/deletee/{id}")
    // public String deleteMovie(@PathVariable("id") Integer id, Model model) {
    // adminGenresService.deleteGenre(id);
    // return "redirect:/admin/listgenres";
    // }

    @GetMapping("/deletee/{id}")
    public String deleteGenre(@PathVariable Integer id) {

        adminGenresService.deleteGenre(id);

        return "redirect:/admin/listgenres";

    }

}
