package com.example.service.admin;

import java.util.List;

import com.example.models.admin.Movie;

public interface AdminMovieService {

    void insertMovies(Movie movie);

    List<Movie> listMovie();

    void deleteMovie(Integer id);

    Movie findMovieId(Integer id);

    void updateMovie(Movie movie);
    
}
