package com.example.models.admin;

import java.io.File;
import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private Integer movieId;
    private Boolean adult;
    private String backdropPath;
    private String belongsToCollection;
    private Integer budget;
    private String homePage;
    private String imdbId;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private float popularity;
    private String posterPath;
    private Date releaseDate;
    private Integer revenue;
    private Integer runtime;
    private String status;
    private String tagline;
    private String title;
    private Boolean video;
    private float voteAverage;
    private Integer voteCount;
}
