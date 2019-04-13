package com.skilldistillery.bandbuilder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.bandbuilder.entities.SocialMedia;
import com.skilldistillery.bandbuilder.repositories.SocialMediaRepository;

public class SocialMediaServiceImpl implements SocialMediaService {
	
	@Autowired
	private SocialMediaRepository socialMediaRepo;

	@Override
	public List<SocialMedia> getAllSocialMedia() {
		return socialMediaRepo.findAll();
	}

	@Override
	public SocialMedia getSocialMediaById(int id) {
		SocialMedia socialMedia = null;
		
		Optional<SocialMedia> opt = socialMediaRepo.findById(id);
		if (opt.isPresent()) {
			socialMedia = opt.get();
		}
		
		return socialMedia;
	}

}
