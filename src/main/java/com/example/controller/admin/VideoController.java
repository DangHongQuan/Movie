package com.example.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.models.admin.Movie;
import com.example.models.admin.Movievideo;
import com.example.models.admin.Video;
import com.example.service.admin.Genres.AdminGenresService;
import com.example.service.admin.Movie.AdminMovieService;
import com.example.service.admin.Movievideo.AdminMovievideoService;
import com.example.service.admin.Video.VideoService;


@Controller
@RequestMapping("/admin/video")
public class VideoController {

	private final VideoService service;

	    @Autowired
	    public VideoController(VideoService service) {
	        this.service = service;
	    }
	// @Autowired
	// private VideoService service;

	@Autowired
	private AdminMovieService adminMovieService;

	@Autowired
	private AdminMovievideoService adminMovievideoService;
	
	@GetMapping("/list")
	public String getListVideo(Model model) {
		List<Video> videos = service.findMany(null);
		model.addAttribute("video", videos);
		return "quanly/pages/videos/list_video";
	}
	
	@GetMapping("/add")
	public String getAddVideo(@ModelAttribute("video") Video video, @ModelAttribute("movieViedeo")  Movievideo movievideo, Model model ) {

		List<Movie> list= adminMovieService.listMovie();
		model.addAttribute("list", list);
		Movievideo movieViedeo=new Movievideo();
		model.addAttribute("movieViedeo", movieViedeo);
		return "quanly/pages/videos/add_video";
	}
	
	@PostMapping("/add")
	public String postAddVideo(@ModelAttribute Video video,@ModelAttribute Movievideo movievideo) {
		// service.insertVideo(video);
		// service.insertMovieVideo(movievideo);
		Integer videoId= service.insertVideoWithMovieVideo(video,movievideo);
		return "redirect:/admin/video/add";
	}
	
	@GetMapping("/editvideo/{id}")
	public String getEditVideo(@PathVariable(value = "id", required = false) Integer videoId, Model model) {
		Video video = service.findOne(videoId);
		model.addAttribute("video", video);
		List<Movie> movies = adminMovieService.listMovie();
		model.addAttribute("listMovie", movies);
		Movievideo movievideo = new Movievideo();
		model.addAttribute("movievideo", movievideo);
		return "quanly/pages/videos/edit_video";
	}
	
	@PostMapping("/editvideo")
	public String postEditVideo(@ModelAttribute("video") Video video,@ModelAttribute("movievideo") Movievideo movievideo) {
		
		Integer videoId= video.getVideoId();
		movievideo.setMvId(videoId);
		movievideo.setMvId(videoId);
		service.updateVideo(video);
		adminMovievideoService.updateMovieVideo(movievideo);

		return "redirect:/admin/video/list";
	}




	
	@GetMapping("/deletevideo/{id}")
	public String deleteVideo(@PathVariable("id") Integer id) {
		service.deleteVideo(id);
		return "redirect:/admin/video/list";
	}
}
