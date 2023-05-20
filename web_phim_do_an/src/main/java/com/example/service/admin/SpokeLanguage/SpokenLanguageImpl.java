package com.example.service.admin.SpokeLanguage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.admin.Moviespokenlanguages;
import com.example.models.admin.Movievideo;
import com.example.models.admin.SpokenLanguage;
import com.example.response.admin.SpokenLanguageMapper;

@Service
public class SpokenLanguageImpl implements SpokenLanguageService{
	private final SpokenLanguageMapper mapper;

    @Autowired
    public SpokenLanguageImpl(SpokenLanguageMapper mapper) {
        this.mapper = mapper;
    }

	// @Autowired
	// private SpokenLanguage language;
	
	// @Autowired
	// private SpokenLanguageMapper mapper;
	
	@Override
	public List<SpokenLanguage> findMany() {
		return mapper.findMany();
	}
	@Override
	public SpokenLanguage findOne(Integer spolangId) {
		return mapper.findOne(spolangId);
	}
	@Override
	public void updateSpolang(SpokenLanguage spoken) {
		mapper.updateSpoken(spoken);
	}
	@Override
	public void deleteSpolang(Integer spolangId) {
		mapper.deleteSpoken(spolangId);
	}
	@Override
	public void insertSpoken(SpokenLanguage spoken) {
		mapper.insertSpoken(spoken);
	}
	@Override
	public void insertMovieSpLa(Moviespokenlanguages moviespokenlanguages) {
		mapper.insertMovieSpLa(moviespokenlanguages);
	}
	@Override
	public Integer insertMovieVideoWithSpokeLa(SpokenLanguage spokenLanguage, Moviespokenlanguages moviespokenlanguages) {
		
		mapper.insertSpoken(spokenLanguage);

		Integer soplangId = spokenLanguage.getSpolangId();

		moviespokenlanguages.setMslId(soplangId);

		mapper.insertMovieSpLa(moviespokenlanguages);

		return soplangId;


	}

	

}
