package com.example.controller.admin;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.models.admin.Movie;
import com.example.models.admin.Movieprodcutioncountry;
import com.example.models.admin.Productioncountrys;
import com.example.service.admin.Movie.AdminMovieService;
import com.example.service.admin.MovieProductioncountrys.AdminMovieProductioncountrysService;
import com.example.service.admin.Productioncountrys.AdminProductioncountrysService;

import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping(value = "/admin")
@Slf4j
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

    @Autowired
    private AdminMovieProductioncountrysService adminMovieProductioncountrysService;


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

    @GetMapping(value = "/listProductioncountry")
    public String listProductioncountrys(Model model){
        List<Productioncountrys> productionCountrys = adminProductioncountrysService.getAllProductioncountrys();
        model.addAttribute("productionCountrys", productionCountrys);
        return "quanly/pages/Productioncountrys/list_productioncountrys";

    }

    @GetMapping(value = "/deleteproductioncountrys/{id}")
    public String deleteProductioncountry(@PathVariable("id") Integer id, Model model){
        adminProductioncountrysService.deleteProductioncountrys(id);
        return "redirect:/admin/listProductioncountry";

    }

    @GetMapping(value = "editproductioncountrys/{id}")
	public String editProductionCountrys(@PathVariable("id") Integer id, Model model){
		Productioncountrys  productioncountrys= adminProductioncountrysService.findProductionCountrys(id);
		model.addAttribute("updateproductioncountrys", productioncountrys);
        List<Movie> movies = adminMovieService.listMovie();
        model.addAttribute("listMovie", movies);
        Movieprodcutioncountry movieprodcutioncountry= new Movieprodcutioncountry();
        model.addAttribute("movieprodcutioncountry", movieprodcutioncountry);
		return "quanly/pages/Productioncountrys/edit_productioncountrys";
	}

	@PostMapping(value = "/updateProductioncountrys")
	public String updateProductionCountrys(@ModelAttribute("updateProductionCountrys") Productioncountrys productioncountrys,
    @ModelAttribute("movieProductionCountrys") Movieprodcutioncountry movieprodcutioncountry){
        Integer pcId = productioncountrys.getPcountryId();
        movieprodcutioncountry.setMpcountryId(pcId);
        Integer productionCompamyId = productioncountrys.getPcountryId();
        movieprodcutioncountry.setPcountryId(productionCompamyId);
		adminProductioncountrysService.updateProductionCountrys(productioncountrys);
        adminMovieProductioncountrysService.updateMovieProductioncountrys(movieprodcutioncountry);
		return "redirect:/admin/listProductioncountry";
	}


    
}
