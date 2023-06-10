package com.example.constants;
import com.example.response.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface MovieApi {
    @GET("/3/movie/now_playing")
    Call<MovieResponse> getNowPlayingMovies(
        @Query("api_key") String apiKey,
        @Query("language") String language,
        @Query("page") int page
    );
}

