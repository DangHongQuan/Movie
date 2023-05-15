package com.example.service.admin.Productioncountrys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.admin.Productioncountrys;
import com.example.response.admin.AdminProductioncountrysRepository;

@Service
public class AdminProductioncountrysServiceimpl implements AdminProductioncountrysService {
    
    @Autowired
    private AdminProductioncountrysRepository adminProductioncountrysRepository;

    @Override
    public void insertProductioncountrys(Productioncountrys productioncountrys) {
        adminProductioncountrysRepository.insertProductioncountrys(productioncountrys);
    }
}
