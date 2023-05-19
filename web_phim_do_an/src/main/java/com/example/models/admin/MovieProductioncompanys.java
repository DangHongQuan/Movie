package com.example.models.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieProductioncompanys {
    private Integer mpcId;
    private Integer productionCompanyId;
    private Integer movieId;
}
