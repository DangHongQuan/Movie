package com.example.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.constants.MovieApi;
import com.example.models.MovieNow;
import com.example.response.MovieResponse;

import retrofit2.Response;

@Service
public class MovieService {
    private static final String API_KEY = "e9e9d8da18ae29fc430845952232787c";
    private static final String LANGUAGE = "en-US";

    private final MovieApi movieApi;

    public MovieService(MovieApi movieApi) {
        this.movieApi = movieApi;
    }

    public List<MovieNow> getNowPlayingMovies(int page) throws IOException {
        Response<MovieResponse> response = movieApi.getNowPlayingMovies(API_KEY, LANGUAGE, page).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }
        MovieResponse movieResponse = response.body();
        if (movieResponse == null) {
            throw new IOException("Null response body");
        }
        return movieResponse.getResults();
    }
}
