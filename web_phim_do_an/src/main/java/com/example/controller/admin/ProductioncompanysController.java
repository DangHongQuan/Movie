package com.example.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.models.ProductionCompany;
import com.example.service.admin.AdminProductioncompanysService;

@RequestMapping(value = "/admin")
@Controller
public class ProductioncompanysController {

    @Autowired
    private AdminProductioncompanysService adminProductioncompanysService;
    
    @GetMapping("/adminproductioncompanys")
    public String addProductioncompanys(Model model) {
        ProductionCompany productionCompany = new ProductionCompany();
        model.addAttribute("productionCompany", productionCompany);
        return "quanly/pages/productioncompanys/add_productioncompanys";
    }

    @PostMapping(value = "/adminproductioncompanys")
    public String addProductionCompany(@ModelAttribute("adminproductioncompanys") ProductionCompany productionCompany) {
        adminProductioncompanysService.insertProductionCompany(productionCompany);
    return "redirect:/admin/adminproductioncompanys";
    }

}
