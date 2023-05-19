package com.example.response.admin;

import org.apache.ibatis.annotations.Mapper;

import com.example.models.admin.MovieProductioncompanys;
import com.example.models.admin.Productioncompanys;

@Mapper
public interface AdminProductioncompanysRepository {

    void insertProductionCompanys(Productioncompanys productionCompanys);

    void insertMovieProductionCompanys(MovieProductioncompanys movieProductioncompanys);

  
    
}
