package com.example.response.admin;

import org.apache.ibatis.annotations.Mapper;

import com.example.models.admin.Movie;
import com.example.models.admin.MovieGenre;

@Mapper
public interface AdminMovieGenreRepository {

    void insertMovieGenres(MovieGenre movieGenre);
    
    
}
