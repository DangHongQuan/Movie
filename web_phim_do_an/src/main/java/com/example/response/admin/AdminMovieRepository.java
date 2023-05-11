package com.example.response.admin;

import org.apache.ibatis.annotations.Mapper;

import com.example.models.admin.Movie;

@Mapper
public interface AdminMovieRepository {

    void insertMovies(Movie movie);
    
}
