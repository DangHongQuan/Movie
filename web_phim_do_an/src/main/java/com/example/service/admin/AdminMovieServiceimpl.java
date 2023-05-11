package com.example.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.admin.Movie;
import com.example.response.admin.AdminMovieRepository;

@Service
public class AdminMovieServiceimpl implements AdminMovieService {

    @Autowired
    private AdminMovieRepository adminMovieRepository;

    @Override
    public void insertMovies(Movie movie) {
       adminMovieRepository.insertMovies(movie);
    }
    
}
