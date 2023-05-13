package com.example.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.ProductionCompany;
import com.example.response.admin.AdminProductioncompanysRepository;

@Service
public class AdminProductioncompanysServiceimpl implements AdminProductioncompanysService {

    @Autowired
    private AdminProductioncompanysRepository adminProductioncompanysRepository;

    @Override
    public void insertProductionCompany(ProductionCompany productionCompany) {
        adminProductioncompanysRepository.insertProductionCompany(productionCompany);
    }
    
}
