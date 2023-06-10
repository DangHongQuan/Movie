package com.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Genre {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    // getters and setters
}