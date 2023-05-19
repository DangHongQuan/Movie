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
import com.example.models.admin.MovieProductioncompanys;
import com.example.models.admin.Productioncompanys;
import com.example.service.admin.Movie.AdminMovieService;
import com.example.service.admin.Productioncompanys.AdminProductioncompanysService;

@RequestMapping(value = "/admin")
@Controller
public class ProductioncompanysController {

    private final AdminProductioncompanysService adminProductioncompanysService2;

	    @Autowired
	    public ProductioncompanysController(AdminProductioncompanysService adminProductioncompanysService2) {
	        this.adminProductioncompanysService2 = adminProductioncompanysService2;
	    }

    @Autowired
    private AdminProductioncompanysService adminProductioncompanysService;

    @Autowired
    private AdminMovieService adminMovieService;
    
    @GetMapping("/adminproductioncompanys")
    public String addProductioncompanys(Model model) {
        Productioncompanys productionCompanys = new Productioncompanys();
        model.addAttribute("productionCompanys", productionCompanys);
        List<Movie> movies = adminMovieService.listMovie();
        model.addAttribute("listMovie", movies);
        return "quanly/pages/productioncompanys/add_productioncompanys";
    }

    @PostMapping(value = "/adminproductioncompanys")
    public String addProductionCompany(@ModelAttribute Productioncompanys productionCompanys, @ModelAttribute MovieProductioncompanys movieProductioncompanys) {
        // adminProductioncompanysService.insertProductionCompanys(productionCompanys);
        // adminProductioncompanysService.insertMovieProductionCompanys(movieProductioncompanys);
        
        Integer movieId = adminProductioncompanysService2.insertMovieProductionCompanyswithProduction(productionCompanys,movieProductioncompanys);
    return "redirect:/admin/adminproductioncompanys";
    }

}
