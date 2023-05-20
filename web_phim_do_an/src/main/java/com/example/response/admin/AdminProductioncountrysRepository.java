package com.example.response.admin;

import org.apache.ibatis.annotations.Mapper;

import com.example.models.admin.Movieprodcutioncountry;
import com.example.models.admin.Productioncountrys;

@Mapper
public interface AdminProductioncountrysRepository {

    void insertProductioncountrys(Productioncountrys productioncountrys);

    void insertMovieProductioncountry(Movieprodcutioncountry movieprodcutioncountry);
    
}
