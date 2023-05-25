package com.example.service.admin.MovieProductioncountrys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.admin.Movieprodcutioncountry;
import com.example.response.admin.AdminMovieProductioncountrysRepository;

@Service
public class AdminMovieProductioncountrysServiceImpl implements AdminMovieProductioncountrysService{

    @Autowired
    private AdminMovieProductioncountrysRepository adminMovieProductioncountrysRepository;

    @Override
    public void updateMovieProductioncountrys(Movieprodcutioncountry movieprodcutioncountry) {
        adminMovieProductioncountrysRepository.updateMovieProductioncountry(movieprodcutioncountry);
    }
    
}
