package com.example.service.admin.Productioncountrys;

import com.example.models.admin.Movieprodcutioncountry;
import com.example.models.admin.Productioncountrys;

public interface AdminProductioncountrysService {

    void insertProductioncountrys(Productioncountrys productioncountrys);

    void insertMovieProductioncountry(Movieprodcutioncountry movieprodcutioncountry);

    Integer insertMovieProductioncountrywhithProductioncountry(Productioncountrys productioncountrys,
            Movieprodcutioncountry movieprodcutioncountry);
    
}
