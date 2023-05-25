package com.example.service.admin.Moviespokenlanguages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.admin.Moviespokenlanguages;
import com.example.response.admin.AdminMoviespokenlanguagesRepository;

@Service
public class AdminMoviespokenlanguagesServiceImpl  implements AdminMoviespokenlanguagesService{

    @Autowired
    private AdminMoviespokenlanguagesRepository adminMoviespokenlanguagesRepository;

  
  


    @Override
    public void updateMovieSpoke(Moviespokenlanguages moviespokenlanguages) {
       adminMoviespokenlanguagesRepository.updateMovieSpoke(moviespokenlanguages);
    }





   
    
}
