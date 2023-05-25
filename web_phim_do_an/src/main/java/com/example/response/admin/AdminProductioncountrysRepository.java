package com.example.response.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.models.admin.Movieprodcutioncountry;
import com.example.models.admin.Productioncountrys;

@Mapper
public interface AdminProductioncountrysRepository {

    void insertProductioncountrys(Productioncountrys productioncountrys);

    void insertMovieProductioncountry(Movieprodcutioncountry movieprodcutioncountry);

    List<Productioncountrys> getAllProductioncountrys();

    void deleteProductioncountrys(Integer id);
    
}
