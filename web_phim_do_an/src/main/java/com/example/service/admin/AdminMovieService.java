package com.example.service.admin;

import java.util.List;

import com.example.models.admin.Movie;

public interface AdminMovieService {

    void insertMovies(Movie movie);

    List<Movie> listMovie();
    
}
