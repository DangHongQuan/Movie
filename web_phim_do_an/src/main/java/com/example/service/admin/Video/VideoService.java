package com.example.service.admin.Video;

import java.util.List;

import com.example.models.admin.Movievideo;
import com.example.models.admin.Video;

public interface VideoService {
	public List<Video> findMany(Integer videoId);
	public void insertVideo(Video video);
	public Video findOne(Integer videoId);
	public void deleteVideo(Integer videoId);
	public void updateVideo(Video video);
    public void insertMovieVideo(Movievideo movievideo);
    public Integer insertVideoWithMovieVideo(Video video, Movievideo movievideo);
}
