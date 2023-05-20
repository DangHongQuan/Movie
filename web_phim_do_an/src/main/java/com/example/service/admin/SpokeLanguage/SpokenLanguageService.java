package com.example.service.admin.SpokeLanguage;

import java.util.List;

import com.example.models.admin.Moviespokenlanguages;
import com.example.models.admin.SpokenLanguage;

public interface SpokenLanguageService {
	public void insertSpoken(SpokenLanguage spoken);
	public List<SpokenLanguage> findMany();
	public  SpokenLanguage findOne(Integer spolangId);
	public void updateSpolang(SpokenLanguage spoken);
	public void deleteSpolang(Integer spolangId);
    public void insertMovieSpLa(Moviespokenlanguages moviespokenlanguages);
    public Integer insertMovieVideoWithSpokeLa(SpokenLanguage spokenLanguage, Moviespokenlanguages moviespokenlanguages);
}
