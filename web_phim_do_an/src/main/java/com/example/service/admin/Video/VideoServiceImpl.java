package com.example.service.admin.Video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.admin.Movievideo;
import com.example.models.admin.Video;
import com.example.response.admin.VideoMapper;

@Service
public class VideoServiceImpl implements VideoService {

	private final VideoMapper mapper;

    @Autowired
    public VideoServiceImpl(VideoMapper mapper) {
        this.mapper = mapper;
    }

	

	@Override
	public List<Video> findMany(Integer videoid) {
		return mapper.findAllVideo(null);
	}

	@Override
	public void insertVideo(Video video) {
		mapper.insertVideo(video);
	}

	@Override
	public void deleteVideo(Integer videoId) {
		mapper.deleteVideo(videoId);
	}

	@Override
	public Video findOne(Integer videoId) {
		return mapper.findOneVideo(videoId);
	}

	@Override
	public void updateVideo(Video video) {
		mapper.updateVideo(video);
	}

	@Override
	public void insertMovieVideo(Movievideo movievideo) {
		mapper.insertMovieVideo(movievideo);
	}



	@Override
	public Integer insertVideoWithMovieVideo(Video video, Movievideo movievideo) {
		mapper.insertVideo(video);

		Integer videoId = video.getVideoId();

		movievideo.setVideoId(videoId);

		mapper.insertMovieVideo(movievideo);

		return videoId;
	}

}
