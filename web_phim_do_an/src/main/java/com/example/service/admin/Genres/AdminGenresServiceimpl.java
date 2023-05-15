package com.example.service.admin.Genres;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Genre;
import com.example.response.admin.AdminGenresRepository;

@Service
public class AdminGenresServiceimpl implements AdminGenresService{

    @Autowired
    private AdminGenresRepository adminGenresRepository;

    @Override
    public void insertGenre(Genre genre) {
       adminGenresRepository.insertGenre(genre);
    }

    @Override
    public List<Genre> getAllGenre() {
        return  adminGenresRepository.getAllGenre();
       
    }
    
}
