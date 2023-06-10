package com.example.response.admin;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.example.models.admin.Movie;
import com.example.models.admin.MovieGenre;

@Mapper
public interface AdminMovieRepository {

//    @Insert("INSERT INTO movies (adult, backdrop_path, belongs_to_collection, budget, homepage, imdb_id, original_language, original_title, overview, popularity, poster_path, release_date, revenue, runtime, status, tagline, title, video, vote_average, vote_count) " +
//            "VALUES (#{adult}, #{backdropPath}, #{belongsToCollection}, #{budget}, #{homePage}, #{imdbId}, #{originalLanguage}, #{originalTitle}, #{overview}, #{popularity}, #{posterPath}, #{releaseDate}, #{revenue}, #{runtime}, #{status}, #{tagline}, #{title}, #{video}, #{voteAverage}, #{voteCount})")
//    @Options(useGeneratedKeys = true, keyProperty = "movieId")
    void insertMovies(Movie movie);
    //dùng để insert vào bảng moviegenres nhé 
    void insertMovieGenres(MovieGenre movieGenre);
  
    List<Movie> listMovie();

    void deleteMovie(Integer id);

    Movie findMovie(Integer id);

    void updateMovie(Movie movie);

    

   
    
}
