package com.example.response.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.models.admin.Movievideo;
import com.example.models.admin.Video;

@Mapper
public interface VideoMapper {
	public List<Video> findAllVideo(Integer videoId);
	public Video findOneVideo(Integer videoId);
	public void insertVideo(Video video);
	public void updateVideo(Video video);
	public void deleteVideo(Integer videoId);
    public void insertMovieVideo(Movievideo movievideo);
}
