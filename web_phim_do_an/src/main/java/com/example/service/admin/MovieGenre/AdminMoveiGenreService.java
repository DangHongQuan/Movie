package com.example.service.admin.MovieGenre;

import com.example.models.admin.MovieGenre;

public interface AdminMoveiGenreService {

    void deleteMovieGenre(Integer id);

    void updateMoveiGenre(MovieGenre movieGenre);

    void updateMoveiGenreEdit(MovieGenre movieGenre);
    
}
