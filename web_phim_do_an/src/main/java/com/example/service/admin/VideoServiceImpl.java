package com.example.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.admin.Video;
import com.example.response.admin.VideoMapper;

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired 
	private VideoMapper mapper;

	@Override
	public List<Video> findMany(Integer videoid) {
		// TODO Auto-generated method stub
		return mapper.findAllVideo(null);
	}

	@Override
	public void insertVideo(Video video) {
		// TODO Auto-generated method stub
		mapper.insertVideo(video);
	}

	@Override
	public void deleteVideo(Integer videoId) {
		// TODO Auto-generated method stub
		mapper.deleteVideo(videoId);
	}

}
