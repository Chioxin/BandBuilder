package com.skilldistillery.bandbuilder.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bandbuilder.entities.SocialMedia;
import com.skilldistillery.bandbuilder.services.SocialMediaService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4220" })
public class SocialMediaController {
	
	@Autowired
	private SocialMediaService socialMediaSvc;
	
	@GetMapping("socialmedia")
	public List<SocialMedia> getAllSocialMedia (HttpServletResponse resp) {
		List<SocialMedia> socialMedia = socialMediaSvc.getAllSocialMedia();
		
		if (socialMedia == null) {
			resp.setStatus(404);
		}
		
		return socialMedia;
	}
	
	@GetMapping("socialmedia/{sid}")
	public SocialMedia getSocialMediaById (@PathVariable("sid") Integer id,
			HttpServletResponse resp) {
		
		SocialMedia socialMedia = socialMediaSvc.getSocialMediaById(id);
		
		if (socialMedia == null) {
			resp.setStatus(404);
		}
		
		return socialMedia;
	}

}
