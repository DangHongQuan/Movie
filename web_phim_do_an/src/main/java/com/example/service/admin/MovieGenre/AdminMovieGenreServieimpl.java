package com.example.service.admin.MovieGenre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.response.admin.AdminMovieGenreReoisitory;

@Service
public class AdminMovieGenreServieimpl implements AdminMoveiGenreService {

    @Autowired
    private AdminMovieGenreReoisitory adminMovieGenreReoisitory;
    

    @Override
    public void deleteMovieGenre(Integer id) {
       adminMovieGenreReoisitory.deleteMovieGenre(id);
    }
    
}
