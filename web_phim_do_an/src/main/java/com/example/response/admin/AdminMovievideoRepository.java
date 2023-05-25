package com.example.response.admin;

import org.apache.ibatis.annotations.Mapper;

import com.example.models.admin.Movievideo;

@Mapper
public interface AdminMovievideoRepository {

    void updateMovieVideo(Movievideo movievideo);
    
}
