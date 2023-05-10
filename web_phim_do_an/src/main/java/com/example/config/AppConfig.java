package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.constants.MovieApi;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
@Configuration
public class AppConfig {
    @Bean
    public MovieApi movieApi() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();
        return retrofit.create(MovieApi.class);
    }
}

