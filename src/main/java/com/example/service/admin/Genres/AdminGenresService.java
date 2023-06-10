package com.example.service.admin.Genres;

import java.util.List;

import com.example.models.Genre;
import com.example.models.admin.Genres;

public interface AdminGenresService {

    void insertGenre(Genre genre);

    List<Genre> getAllGenre();

    void deleteGenre(Integer id);

    Genres findGenresId(Integer id);

    void updateGenres(Genres genres);

    void capnhatGenre(Genres genres);
    
}
