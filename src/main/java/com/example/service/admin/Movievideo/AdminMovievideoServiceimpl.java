package com.example.service.admin.Movievideo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.admin.Movievideo;
import com.example.response.admin.AdminMovievideoRepository;

@Service
public class AdminMovievideoServiceimpl implements AdminMovievideoService{

    @Autowired
    private AdminMovievideoRepository adminMovievideoRepository;

    @Override
    public void updateMovieVideo(Movievideo movievideo) {
        adminMovievideoRepository.updateMovieVideo(movievideo);
    }
    
}
