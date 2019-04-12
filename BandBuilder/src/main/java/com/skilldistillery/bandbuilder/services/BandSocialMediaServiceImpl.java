package com.skilldistillery.bandbuilder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.bandbuilder.entities.BandSocialMedia;
import com.skilldistillery.bandbuilder.repositories.BandSocialMediaRepository;

public class BandSocialMediaServiceImpl implements BandSocialMediaService {
	
	@Autowired
	private BandSocialMediaRepository bandSocialMediaRepo;
	
//	Not sure if this is even needed, assuming the Social Media is provided from the front end.
//	@Autowired
//	private SocialMediaRepository socialMediaRepo;

	@Override
	public List<BandSocialMedia> getBandSocialMediaByBandId(int id) {
		return bandSocialMediaRepo.findByBandId(id);
	}

	@Override
	public BandSocialMedia getBandSocialMediaById(int id) {
		BandSocialMedia bsm = null;
		
		Optional<BandSocialMedia> opt = bandSocialMediaRepo.findById(id);
		if (opt.isPresent()) {
			bsm = opt.get();
		}
		
		return bsm;
	}

	@Override
	public BandSocialMedia createBandSocialMedia(BandSocialMedia bandSocialMedia) {
		return bandSocialMediaRepo.saveAndFlush(bandSocialMedia);
	}

	@Override
	public BandSocialMedia updateBandSocialMediaById(int id, BandSocialMedia updatedBandSocialMedia) {
		BandSocialMedia managed = null;
		
		Optional<BandSocialMedia> opt = bandSocialMediaRepo.findById(id);
		if (opt.isPresent()) {
			managed = opt.get();
			managed.setBand(updatedBandSocialMedia.getBand());
			managed.setSocialMedia(updatedBandSocialMedia.getSocialMedia());
			managed.setUrl(updatedBandSocialMedia.getUrl());
			managed.setActive(updatedBandSocialMedia.isActive());
			managed = bandSocialMediaRepo.saveAndFlush(managed);
		}
			
		return managed;
	}

	@Override
	public Boolean deleteBandSocialMediaById(int id) {
		Boolean deleted = false;
		
		Optional<BandSocialMedia> opt = bandSocialMediaRepo.findById(id);
		if (opt.isPresent()) {
			BandSocialMedia managed = opt.get();
			managed.setActive(false);
			bandSocialMediaRepo.saveAndFlush(managed);
			deleted = true;
		}
		
		return deleted;
	}

}
