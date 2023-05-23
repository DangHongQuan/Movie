package com.example.service.admin.Productioncompanys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.admin.MovieProductioncompanys;
import com.example.models.admin.Productioncompanys;
import com.example.response.admin.AdminProductioncompanysRepository;

@Service
public class AdminProductioncompanysServiceimpl implements AdminProductioncompanysService {

    private final AdminProductioncompanysRepository adminProductioncompanysRepository ;

    @Autowired
    public AdminProductioncompanysServiceimpl(AdminProductioncompanysRepository adminProductioncompanysRepository) {
        this.adminProductioncompanysRepository = adminProductioncompanysRepository;
//	        this.adminMovieGenreRepository = adminMovieGenreRepository;
    }
    // @Autowired
    // private AdminProductioncompanysRepository adminProductioncompanysRepository;

    @Override
    public void insertProductionCompanys(Productioncompanys productionCompanys) {
        adminProductioncompanysRepository.insertProductionCompanys(productionCompanys);
    }

    @Override
    public void insertMovieProductionCompanys(MovieProductioncompanys movieProductioncompanys) {
       adminProductioncompanysRepository.insertMovieProductionCompanys(movieProductioncompanys);
    }

    @Override
    public Integer insertMovieProductionCompanyswithProduction(Productioncompanys productionCompanys,
            MovieProductioncompanys movieProductioncompanys) {
                adminProductioncompanysRepository.insertProductionCompanys(productionCompanys);
                
                Integer ProducCompaynId = productionCompanys.getPcId();

                movieProductioncompanys.setProductionCompanyId(ProducCompaynId);

                adminProductioncompanysRepository.insertMovieProductionCompanys(movieProductioncompanys);

       return ProducCompaynId;
    }

    @Override
    public List<Productioncompanys> getAllProductioncompanys() {
      return adminProductioncompanysRepository.getAllProductioncompanys();
    }

    @Override
    public void deleteProductioncompanys(Integer id) {
     adminProductioncompanysRepository.deleteProductionCompanies(id);
    }

    @Override
    public Productioncompanys findProductioncompaynsId(Integer id) {
      return adminProductioncompanysRepository.findProductionCompayns(id);
    }

    @Override
    public void updateProductioncompanys(Productioncompanys productioncompanys) {
       adminProductioncompanysRepository.updateProductionCompanies(productioncompanys);
    }

    
}
