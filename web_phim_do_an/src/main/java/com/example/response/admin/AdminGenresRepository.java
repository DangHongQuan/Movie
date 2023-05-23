package com.example.response.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.models.Genre;

@Mapper
public interface AdminGenresRepository {

    void insertGenre(Genre genre);

    List<Genre> getAllGenre();

    void deleteGenre(Integer id);
    
}
