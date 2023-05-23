package com.example.response.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.models.admin.MovieProductioncompanys;
import com.example.models.admin.Productioncompanys;

@Mapper
public interface AdminProductioncompanysRepository {

    void insertProductionCompanys(Productioncompanys productionCompanys);

    void insertMovieProductionCompanys(MovieProductioncompanys movieProductioncompanys);

    List<Productioncompanys> getAllProductioncompanys();

    void deleteProductionCompanies(Integer id);

    Productioncompanys findProductionCompayns(Integer id);

    void updateProductionCompanies(Productioncompanys productioncompanys);

  
    
}
