package com.example.models;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieNow {
	 private boolean adult;
	 @JsonProperty("backdrop_path")
	    private String backdropPath;
	 @JsonProperty("genre_ids")
	 private List<Integer> genreIds;
	 private String originalLanguage;
	    private int id;
	    private String originalTitle;
	    private String overview;
	    private double popularity;
	    private String posterPath;
	    private String releaseDate;
	    private String title;
	    private boolean video;
	    private double voteAverage;
	    private int voteCount;
}
