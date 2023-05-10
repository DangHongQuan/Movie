package com.example.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class VideoList {
    @JsonProperty("results")
    private List<Video> results;

}

