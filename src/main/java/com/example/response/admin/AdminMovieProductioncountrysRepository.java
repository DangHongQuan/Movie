package com.example.response.admin;

import org.apache.ibatis.annotations.Mapper;

import com.example.models.admin.Movieprodcutioncountry;

@Mapper
public interface AdminMovieProductioncountrysRepository {

    void updateMovieProductioncountry(Movieprodcutioncountry movieprodcutioncountry);
    
}
