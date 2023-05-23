package com.example.response.admin;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMovieGenreReoisitory {

    void deleteMovieGenre(Integer id);
    
}
