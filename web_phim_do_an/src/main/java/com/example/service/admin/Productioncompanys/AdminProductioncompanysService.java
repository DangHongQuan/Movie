package com.example.service.admin.Productioncompanys;

import java.util.List;

import com.example.models.admin.MovieProductioncompanys;
import com.example.models.admin.Productioncompanys;

public interface AdminProductioncompanysService {

    void insertProductionCompanys(Productioncompanys productionCompanys);

    void insertMovieProductionCompanys(MovieProductioncompanys movieProductioncompanys);

    Integer insertMovieProductionCompanyswithProduction(Productioncompanys productionCompanys,
            MovieProductioncompanys movieProductioncompanys);

    List<Productioncompanys> getAllProductioncompanys();

    void deleteProductioncompanys(Integer id);

    Productioncompanys findProductioncompaynsId(Integer id);

    void updateProductioncompanys(Productioncompanys productioncompanys);
    
}
