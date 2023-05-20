package com.example.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.admin.SpokenLanguage;
import com.example.response.admin.SpokenLanguageMapper;

@Service
public class SpokenLanguageImpl implements SpokenLanguageService{
	
	@Autowired
	private SpokenLanguageMapper mapper;
	@Override
	public void insertSpoken(SpokenLanguage spoken) {
		// TODO Auto-generated method stub
		mapper.insertSpoken(spoken);
	}

}
