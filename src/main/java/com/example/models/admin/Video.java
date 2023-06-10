package com.example.models.admin;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
 private Integer videoId;
 private String iso6391;
 private String iso31661;
 private String name;
 private String keyYt;
 private String site;
 private Integer size;
 private String type;
 private Boolean official;
 private Date publishedAt;
}
