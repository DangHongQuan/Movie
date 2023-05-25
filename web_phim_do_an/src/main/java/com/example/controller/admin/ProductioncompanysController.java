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
import com.example.models.admin.MovieProductioncompanys;
import com.example.models.admin.Productioncompanys;
import com.example.service.admin.Movie.AdminMovieService;
import com.example.service.admin.Movieproductioncompany.AdminMovieProductioncompanysService;
import com.example.service.admin.Productioncompanys.AdminProductioncompanysService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.mysql.cj.log.Log;

import lombok.extern.slf4j.Slf4j;



@RequestMapping(value = "/admin")
@Controller
@Slf4j
public class ProductioncompanysController {

    
    private final AdminProductioncompanysService adminProductioncompanysService2;



	    @Autowired
	    public ProductioncompanysController(AdminProductioncompanysService adminProductioncompanysService2) {
	        this.adminProductioncompanysService2 = adminProductioncompanysService2;
	    }

    @Autowired
    private AdminProductioncompanysService adminProductioncompanysService;

    @Autowired
    private AdminMovieProductioncompanysService adminMovieProductioncompanysService;

  

    

    @Autowired
    private AdminMovieService adminMovieService;
    
    @GetMapping("/adminproductioncompanys")
    public String addProductioncompanys(Model model) {
        Productioncompanys productionCompanys = new Productioncompanys();
        model.addAttribute("productionCompanys", productionCompanys);
        List<Movie> movies = adminMovieService.listMovie();
        model.addAttribute("listMovie", movies);
        MovieProductioncompanys movieProductioncompanys=new MovieProductioncompanys();
        model.addAttribute("movieProductioncompanys", movieProductioncompanys);
       
        return "quanly/pages/productioncompanys/add_productioncompanys";
    }

    @PostMapping(value = "/adminproductioncompanys")
    public String addProductionCompany(@ModelAttribute Productioncompanys productionCompanys, @ModelAttribute MovieProductioncompanys movieProductioncompanys) {
        // adminProductioncompanysService.insertProductionCompanys(productionCompanys);
        // adminProductioncompanysService.insertMovieProductionCompanys(movieProductioncompanys);
        
        Integer movieId = adminProductioncompanysService2.insertMovieProductionCompanyswithProduction(productionCompanys,movieProductioncompanys);
    return "redirect:/admin/adminproductioncompanys";
    }

    @GetMapping(value = "/listproductioncompanys")
    public String listProductioncompanys(Model model){
        List<Productioncompanys> productioncompanys = adminProductioncompanysService2.getAllProductioncompanys();
        model.addAttribute("productioncompanys", productioncompanys);

        return "quanly/pages/productioncompanys/list_productioncompanys";

    }

    @GetMapping(value = "deleteproductioncompanys/{id}")
    public String deleteProductioncompanys(@PathVariable("id") Integer id, Model model){
        adminProductioncompanysService2.deleteProductioncompanys(id);
        return "redirect:/admin/listproductioncompanys";

    }
    @GetMapping(value = "editproductioncompanys/{id}")
	public String editProductioncompany(@PathVariable("id") Integer id, Model model){
		Productioncompanys productioncompanys = adminProductioncompanysService2.findProductioncompaynsId(id);
		model.addAttribute("updateproductioncompanys", productioncompanys);
        List<Movie> movies = adminMovieService.listMovie();
        model.addAttribute("listMovie", movies);
        MovieProductioncompanys movieProductioncompanys= new MovieProductioncompanys();
        model.addAttribute("productioncompanys", movieProductioncompanys);
		return "quanly/pages/productioncompanys/edit_productioncompanys";
	}

	@PostMapping(value = "/updateProductioncompanys")
	public String updateProductioncompany(@ModelAttribute("updateproductioncompanys") Productioncompanys productioncompanys,
    @ModelAttribute("movieProductioncompanys") MovieProductioncompanys movieProductioncompanys){
        Integer pcId = productioncompanys.getPcId();
        movieProductioncompanys.setMpcId(pcId);
        
        Integer productionCompamyId = productioncompanys.getPcId();
        movieProductioncompanys.setProductionCompanyId(productionCompamyId);
		adminProductioncompanysService2.updateProductioncompanys(productioncompanys);
        adminMovieProductioncompanysService.updateMovieProductioncampanys(movieProductioncompanys);
		return "redirect:/admin/listproductioncompanys";
	}

}
