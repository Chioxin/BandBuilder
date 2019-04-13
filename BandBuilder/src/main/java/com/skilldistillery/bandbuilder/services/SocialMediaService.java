package com.skilldistillery.bandbuilder.services;

import java.util.List;

import com.skilldistillery.bandbuilder.entities.SocialMedia;

public interface SocialMediaService {
	
	public List<SocialMedia> getAllSocialMedia ();
	public SocialMedia getSocialMediaById (int id);
		
}
