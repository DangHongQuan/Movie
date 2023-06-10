package com.example.service.admin.Movie;

import java.util.List;

import com.example.models.admin.Movie;
import com.example.models.admin.MovieGenre;

public interface AdminMovieService {
	Integer insertMovieWithGenre(Movie movie, MovieGenre movieGenre);
    void insertMovies(Movie movie);
    void insertMovieGenres(MovieGenre movieGenre);

    List<Movie> listMovie();

    void deleteMovie(Integer id);

    Movie findMovieId(Integer id);

    void updateMovie(Movie movie);
    
}
