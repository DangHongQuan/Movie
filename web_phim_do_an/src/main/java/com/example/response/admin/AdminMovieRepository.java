package com.example.response.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.models.admin.Movie;

@Mapper
public interface AdminMovieRepository {

    void insertMovies(Movie movie);

    List<Movie> listMovie();

    void deleteMovie(Integer id);

    Movie findMovie(Integer id);

    void updateMovie(Movie movie);

    

   
    
}
