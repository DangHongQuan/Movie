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

import com.example.models.admin.Video;
import com.example.service.admin.VideoService;


@Controller
@RequestMapping("/admin/video")
public class VideoController {
	@Autowired
	private VideoService service;
	
	@GetMapping("/list")
	public String getListVideo(Model model) {
		List<Video> videos = service.findMany(null);
		model.addAttribute("video", videos);
		return "quanly/pages/videos/list_video";
	}
	
	@GetMapping("/add")
	public String getAddVideo(@ModelAttribute("video") Video video) {
		return "quanly/pages/videos/add_video";
	}
	
	@PostMapping("/add")
	public String postAddVideo(@ModelAttribute Video video) {
		service.insertVideo(video);
		return "redirect:/admin/video/add";
	}
	
	@GetMapping("/edit/{id}")
	public String getEditVideo(@PathVariable(value = "id", required = false) Integer videoId, Model model) {
		Video video = service.findOne(videoId);
		model.addAttribute("video", video);
		return "quanly/pages/videos/edit_video";
	}
	
	@PostMapping("/edit")
	public String postEditVideo(@ModelAttribute("video") Video video) {
		service.updateVideo(video);
		return "redirect:/admin/video/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteVideo(@PathVariable("id") Integer id) {
		service.deleteVideo(id);
		return "redirect:/admin/video/list";
	}
}
