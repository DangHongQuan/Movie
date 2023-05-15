package com.example.models.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productioncountrys {
    private Integer pcountryId;
    private String iso31661;
    private String name;
}
