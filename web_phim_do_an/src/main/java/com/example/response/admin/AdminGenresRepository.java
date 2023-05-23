package com.example.response.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.models.Genre;
import com.example.models.admin.Genres;

@Mapper
public interface AdminGenresRepository {

    void insertGenre(Genre genre);

    List<Genre> getAllGenre();

    void deleteGenre(Integer id);

    void updateGenres(Genres genres);

    Genres findGenresId(Integer id);

    void capnhatGenres(Genres genres);
    
}
