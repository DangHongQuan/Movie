package com.example.response.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.models.admin.Moviespokenlanguages;
import com.example.models.admin.Movievideo;
import com.example.models.admin.SpokenLanguage;

@Mapper
public interface SpokenLanguageMapper {
	public List<SpokenLanguage> findMany();
	public SpokenLanguage findOne(Integer spokenId);
	public void updateSpoken(SpokenLanguage spoken);
	public void deleteSpoken(Integer spokenId);
    public void insertMovieVideo(Movievideo movievideo);
	public void insertMovieSpLa(Moviespokenlanguages moviespokenlanguages);
    public void insertSpoken(SpokenLanguage spoken);

}
