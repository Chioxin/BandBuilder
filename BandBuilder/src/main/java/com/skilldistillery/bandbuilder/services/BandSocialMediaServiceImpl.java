package com.skilldistillery.bandbuilder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.bandbuilder.entities.BandSocialMedia;
import com.skilldistillery.bandbuilder.repositories.BandSocialMediaRepository;
import com.skilldistillery.bandbuilder.repositories.SocialMediaRepository;

public class BandSocialMediaServiceImpl implements BandSocialMediaService {
	
	@Autowired
	private BandSocialMediaRepository bandSocialMediaRepo;
	
	@Autowired
	private SocialMediaRepository socialMediaRepo;

	@Override
	public List<BandSocialMedia> getBandSocialMediaByBandId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BandSocialMedia getBandSocialMediaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BandSocialMedia createBandSocialMedia(BandSocialMedia bandSocialMedia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BandSocialMedia updateBandSocialMediaById(int id, BandSocialMedia updatedBandSocialMedia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteBandSocialMediaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
