package com.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SpokenLanguage {
@JsonProperty("english_name")
private String englishname;
@JsonProperty("iso_639_1")
private String iso6391;
@JsonProperty("name")
private String name;
}
