package com.example.service.admin.Movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.admin.Movie;
import com.example.models.admin.MovieGenre;

import com.example.response.admin.AdminMovieRepository;

@Service
public class AdminMovieServiceimpl implements AdminMovieService {
	private final AdminMovieRepository adminMovieRepository;
//	private final AdminMovieGenreRepository adminMovieGenreRepository;

	 @Autowired
	    public AdminMovieServiceimpl(AdminMovieRepository adminMovieRepository) {
	        this.adminMovieRepository = adminMovieRepository;
//	        this.adminMovieGenreRepository = adminMovieGenreRepository;
	    }
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

@Override
public void insertMovieGenres(MovieGenre movieGenre) {
	// TODO Auto-generated method stub
	adminMovieRepository.insertMovieGenres(movieGenre);
}

@Override
public Integer insertMovieWithGenre(Movie movie, MovieGenre movieGenre) {
	// Thêm dữ liệu vào bảng movie
    adminMovieRepository.insertMovies(movie);

    // Lấy movieId mới được tạo
    Integer movieId = movie.getMovieId();

    // Thiết lập movieId cho movieGenre
    movieGenre.setMovieId(movieId);

    // Thêm dữ liệu vào bảng moviegenre
    adminMovieRepository.insertMovieGenres(movieGenre);

    return movieId;
}
    
}
