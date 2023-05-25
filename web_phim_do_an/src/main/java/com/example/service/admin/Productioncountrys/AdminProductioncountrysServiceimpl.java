package com.example.service.admin.Productioncountrys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.admin.Movieprodcutioncountry;
import com.example.models.admin.Productioncountrys;
import com.example.response.admin.AdminProductioncountrysRepository;

@Service
public class AdminProductioncountrysServiceimpl implements AdminProductioncountrysService {

    private final AdminProductioncountrysRepository adminProductioncountrysRepository;

    @Autowired
    public AdminProductioncountrysServiceimpl(AdminProductioncountrysRepository adminProductioncountrysRepository) {
        this.adminProductioncountrysRepository = adminProductioncountrysRepository;
        // this.adminMovieGenreRepository = adminMovieGenreRepository;
    }
    // @Autowired
    // private AdminProductioncountrysRepository adminProductioncountrysRepository;

    @Override
    public void insertProductioncountrys(Productioncountrys productioncountrys) {
        adminProductioncountrysRepository.insertProductioncountrys(productioncountrys);
    }

    @Override
    public void insertMovieProductioncountry(Movieprodcutioncountry movieprodcutioncountry) {

        adminProductioncountrysRepository.insertMovieProductioncountry(movieprodcutioncountry);
    }

    @Override
    public Integer insertMovieProductioncountrywhithProductioncountry(Productioncountrys productioncountrys,
            Movieprodcutioncountry movieprodcutioncountry) {

        adminProductioncountrysRepository.insertProductioncountrys(productioncountrys);

        Integer productioncontruyId = productioncountrys.getPcountryId();

        movieprodcutioncountry.setPcountryId(productioncontruyId);

        adminProductioncountrysRepository.insertMovieProductioncountry(movieprodcutioncountry);
        return productioncontruyId;
    }

    @Override
    public List<Productioncountrys> getAllProductioncountrys() {
        return adminProductioncountrysRepository.getAllProductioncountrys();
    }

    @Override
    public void deleteProductioncountrys(Integer id) {
     adminProductioncountrysRepository.deleteProductioncountrys(id);
    }

   
}
