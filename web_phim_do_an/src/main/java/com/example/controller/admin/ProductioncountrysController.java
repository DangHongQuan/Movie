package com.example.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.models.admin.Movie;
import com.example.models.admin.Movieprodcutioncountry;
import com.example.models.admin.Productioncountrys;
import com.example.service.admin.Movie.AdminMovieService;
import com.example.service.admin.Productioncountrys.AdminProductioncountrysService;

@Controller
@RequestMapping(value = "/admin")
public class ProductioncountrysController {

    private final AdminProductioncountrysService adminProductioncountrysService2;

    @Autowired
    public ProductioncountrysController(AdminProductioncountrysService adminProductioncountrysService2) {
        this.adminProductioncountrysService2 = adminProductioncountrysService2;
    }
    
    @Autowired
    private AdminProductioncountrysService adminProductioncountrysService;

    @Autowired
    private AdminMovieService adminMovieService;


    @GetMapping("/adminProductioncountrys")
    public String addProductioncompanys(Model model) {
        Productioncountrys productioncountrys = new Productioncountrys();
        model.addAttribute("productioncountrys", productioncountrys);
        List<Movie> movies = adminMovieService.listMovie();
        model.addAttribute("listMovieProductioncountry", movies);
        Movieprodcutioncountry movieprodcutioncountry= new Movieprodcutioncountry();
        model.addAttribute("prodcutioncountry", movieprodcutioncountry);
        return "quanly/pages/Productioncountrys/add_productioncountrys";
    }

    @PostMapping(value = "/adminProductioncountrys")
    public String addProductionCompany(@ModelAttribute Productioncountrys productioncountrys, @ModelAttribute Movieprodcutioncountry movieprodcutioncountry) {
        // adminProductioncountrysService.insertProductioncountrys(productioncountrys);
        // adminProductioncountrysService.insertMovieProductioncountry(movieprodcutioncountry);
        Integer  productioncontruyId= adminProductioncountrysService2.insertMovieProductioncountrywhithProductioncountry(productioncountrys, movieprodcutioncountry);

        return "redirect:/admin/adminProductioncountrys";
    }
    
}
