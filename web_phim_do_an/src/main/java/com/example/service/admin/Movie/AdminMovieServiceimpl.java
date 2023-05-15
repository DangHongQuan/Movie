package com.example.service.admin.Movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.admin.Movie;
import com.example.response.admin.AdminMovieRepository;

@Service
public class AdminMovieServiceimpl implements AdminMovieService {

    @Autowired
    private AdminMovieRepository adminMovieRepository;

    @Override
    public void insertMovies(Movie movie) {
       adminMovieRepository.insertMovies(movie);
    }

    @Override
    public List<Movie> listMovie() {
       return adminMovieRepository.listMovie();
    }

   @Override
   public void deleteMovie(Integer id) {
     adminMovieRepository.deleteMovie(id);
   }

   @Override
   public Movie findMovieId(Integer id) {
     return adminMovieRepository.findMovie(id);
   }

   @Override
   public void updateMovie(Movie movie) {
    adminMovieRepository.updateMovie(movie);
   }
    
}
