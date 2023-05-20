package com.example.service.admin;

import java.util.List;

import com.example.models.admin.Video;

public interface VideoService {
	public List<Video> findMany(Integer videoId);
	public void insertVideo(Video video);
	public Video findOne(Integer videoId);
	public void deleteVideo(Integer videoId);
	public void updateVideo(Video video);
}
