package com.example.response.admin;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.models.admin.MovieProductioncompanys;
import com.example.models.admin.Productioncompanys;

@Mapper
public interface AdminMovieProductioncompanysRepository {

    void updateMovieProductioncampanys( MovieProductioncompanys movieProductioncompanys);


    
}
