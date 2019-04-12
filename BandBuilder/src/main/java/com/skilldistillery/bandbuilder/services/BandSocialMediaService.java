package com.skilldistillery.bandbuilder.services;

import java.util.List;

import com.skilldistillery.bandbuilder.entities.BandSocialMedia;

public interface BandSocialMediaService {
	
	public List<BandSocialMedia> getBandSocialMediaByBandId (int id);
	public BandSocialMedia getBandSocialMediaById (int id);
	public BandSocialMedia createBandSocialMedia (BandSocialMedia bandSocialMedia);
	public BandSocialMedia updateBandSocialMediaById (int id, BandSocialMedia updatedBandSocialMedia);
	public Boolean deleteBandSocialMediaById (int id);

}
