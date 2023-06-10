package com.example.response.admin;

import org.apache.ibatis.annotations.Mapper;

import com.example.models.admin.MovieGenre;

@Mapper
public interface AdminMovieGenreReoisitory {

    void deleteMovieGenre(Integer id);

    void updateMoveiGenre(MovieGenre movieGenre);

    void updateMoveiGenreEdit(MovieGenre movieGenre);
    
}
