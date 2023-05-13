package com.example.response.admin;

import org.apache.ibatis.annotations.Mapper;

import com.example.models.ProductionCompany;

@Mapper
public interface AdminProductioncompanysRepository {

    void insertProductionCompany(ProductionCompany productionCompany);

  
    
}
