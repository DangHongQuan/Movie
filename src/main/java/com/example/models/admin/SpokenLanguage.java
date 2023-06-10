package com.example.models.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpokenLanguage {
	private Integer spolangId;
	private String iso6391;
	private String englishName;
	private String name;
	
}
