package com.example.models.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productioncompanys {
    private Integer pcId;
    private String  logoPath;
    private String name;
    private String originCountry;
}
