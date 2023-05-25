package com.example.response.admin;

import org.apache.ibatis.annotations.Mapper;

import com.example.models.admin.Moviespokenlanguages;

@Mapper
public interface AdminMoviespokenlanguagesRepository {

    void updateMovieSpoke(Moviespokenlanguages moviespokenlanguages);
    
}
