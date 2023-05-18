package com.example.service.admin.MovieGenre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.admin.Movie;
import com.example.models.admin.MovieGenre;
import com.example.response.admin.AdminMovieGenreRepository;

@Service
public class AdminMovieGenreServiceimpl implements AdminMovieGenreService{

    @Autowired
    private AdminMovieGenreRepository adminMovieGenreRepository;

    @Override
    public void insertMovieGenres(MovieGenre movieGenre) {
    adminMovieGenreRepository.insertMovieGenres(movieGenre);
    }

 
    
}
