package com.example.service.admin.Movieproductioncompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.admin.MovieProductioncompanys;
import com.example.models.admin.Productioncompanys;
import com.example.response.admin.AdminMovieProductioncompanysRepository;

@Service
public class AdminMovieProductioncompanysServiceImpl implements AdminMovieProductioncompanysService{

    @Autowired
    private AdminMovieProductioncompanysRepository adminMovieProductioncompanysRepository;

    @Override
    public void updateMovieProductioncampanys(MovieProductioncompanys movieProductioncompanys) {
      adminMovieProductioncompanysRepository.updateMovieProductioncampanys(movieProductioncompanys);
    }

    
    
}
