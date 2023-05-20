package com.example.service.admin;

import java.util.List;

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
	@Override
	public List<SpokenLanguage> findMany() {
		// TODO Auto-generated method stub
		return mapper.findMany();
	}
	@Override
	public SpokenLanguage findOne(Integer spolangId) {
		// TODO Auto-generated method stub
		return mapper.findOne(spolangId);
	}
	@Override
	public void updateSpolang(SpokenLanguage spoken) {
		// TODO Auto-generated method stub
		mapper.updateSpoken(spoken);
	}
	@Override
	public void deleteSpolang(Integer spolangId) {
		// TODO Auto-generated method stub
		mapper.deleteSpoken(spolangId);
	}

}
