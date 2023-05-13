package com.example.service.admin;

import java.util.List;

import com.example.models.Genre;

public interface AdminGenresService {

    void insertGenre(Genre genre);

    List<Genre> getAllGenre();
    
}
