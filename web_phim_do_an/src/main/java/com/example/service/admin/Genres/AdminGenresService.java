package com.example.service.admin.Genres;

import java.util.List;

import com.example.models.Genre;

public interface AdminGenresService {

    void insertGenre(Genre genre);

    List<Genre> getAllGenre();
    
}
