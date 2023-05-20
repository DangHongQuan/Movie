package com.example.service.admin;

import java.util.List;

import com.example.models.admin.Video;

public interface VideoService {
	public List<Video> findMany(Integer videoId);
	public void insertVideo(Video video);
	public void deleteVideo(Integer videoId);
}
