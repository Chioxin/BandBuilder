package com.skilldistillery.bandbuilder.services;

import java.util.List;

import com.skilldistillery.bandbuilder.datatransferobjects.ProfileDTO;
import com.skilldistillery.bandbuilder.entities.Profile;

public interface ProfileService {
	
	public List<Profile> getAllProfiles();
	public Profile getProfileById(int id);
	public Profile createProfile(ProfileDTO regInfo);
	public Profile updateProfileById(int id, Profile profile);
	public Boolean deleteProfileById(int id);
	public Profile getProfileByUserName(String username);

}
