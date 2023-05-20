package com.example.service.admin;

import java.util.List;

import com.example.models.admin.SpokenLanguage;

public interface SpokenLanguageService {
	public void insertSpoken(SpokenLanguage spoken);
	public List<SpokenLanguage> findMany();
	public  SpokenLanguage findOne(Integer spolangId);
	public void updateSpolang(SpokenLanguage spoken);
	public void deleteSpolang(Integer spolangId);
}
