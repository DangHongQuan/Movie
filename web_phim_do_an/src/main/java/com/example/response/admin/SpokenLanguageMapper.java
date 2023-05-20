package com.example.response.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.models.admin.SpokenLanguage;

@Mapper
public interface SpokenLanguageMapper {
	public List<SpokenLanguage> findMany();
	public SpokenLanguage findOne(Integer spokenId);
	public void insertSpoken(SpokenLanguage spoken);
	public void updateSpoken(SpokenLanguage spoken);
	public void deleteSpoken(Integer spokenId);
}
