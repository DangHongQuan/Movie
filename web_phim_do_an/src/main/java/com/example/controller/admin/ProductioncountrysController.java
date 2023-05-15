package com.example.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.models.admin.Productioncountrys;
import com.example.service.admin.Productioncountrys.AdminProductioncountrysService;

@Controller
@RequestMapping(value = "/admin")
public class ProductioncountrysController {
    
    @Autowired
    private AdminProductioncountrysService adminProductioncountrysService;


    @GetMapping("/adminProductioncountrys")
    public String addProductioncompanys(Model model) {
        Productioncountrys productioncountrys = new Productioncountrys();
        model.addAttribute("productioncountrys", productioncountrys);
        return "quanly/pages/Productioncountrys/add_productioncountrys";
    }

    @PostMapping(value = "/adminProductioncountrys")
    public String addProductionCompany(@ModelAttribute("adminProductioncountrys") Productioncountrys productioncountrys) {
        adminProductioncountrysService.insertProductioncountrys(productioncountrys);
    return "redirect:/admin/adminproductioncompanys";
    }
    
}
