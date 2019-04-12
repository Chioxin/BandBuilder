package com.skilldistillery.bandbuilder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.bandbuilder.datatransferobjects.RegistrationDTO;
import com.skilldistillery.bandbuilder.entities.Profile;
import com.skilldistillery.bandbuilder.repositories.ProfileRepository;

public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileRepository profileRepo;

	@Override
	public List<Profile> getAllProfiles() {
		return profileRepo.findAll();
	}

	@Override
	public Profile getProfileById(int id) {
		Profile profile = null;
		
		Optional<Profile> opt = profileRepo.findById(id);
		if (opt.isPresent()) {
			profile = opt.get();
		}
		
		return profile;
	}

	@Override
	public Profile createProfile(RegistrationDTO regInfo) {
		Profile profile = new Profile();
		// Needs ADDRESS and USER Services to work
		
		return profileRepo.saveAndFlush(profile);
	}

	@Override
	public Profile updateProfileById(int id, Profile profile) {
		Profile managed = null;
		Optional<Profile> opt = profileRepo.findById(id);
		
		if (opt.isPresent()) {
			managed = opt.get();
			
			managed.setUser(profile.getUser());
			managed.setFirstName(profile.getFirstName());
			managed.setLastName(profile.getLastName());
			managed.setAboutMe(profile.getAboutMe());
			managed.setAddress(profile.getAddress());
			managed.setImage(profile.getImage());
			managed.setCreatedAt(profile.getCreatedAt());
			managed.setUpdatedAt(profile.getUpdatedAt());
			managed.setBands(profile.getBands());
			managed.setBandMembers(profile.getBandMembers());
			managed.setInstruments(profile.getInstruments());
		}
		
		return managed;
	}

	@Override
	public Boolean deleteProfileById(int id) {
		Boolean deleted = false;
		
		Optional opt = profileRepo.findById(id);
		if (opt.isPresent()) {
			profileRepo.deleteById(id);
			deleted = true;
		}

		return deleted;
	}

}
