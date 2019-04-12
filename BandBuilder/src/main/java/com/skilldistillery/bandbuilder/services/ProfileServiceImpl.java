package com.skilldistillery.bandbuilder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.bandbuilder.datatransferobjects.ProfileDTO;
import com.skilldistillery.bandbuilder.entities.Address;
import com.skilldistillery.bandbuilder.entities.Image;
import com.skilldistillery.bandbuilder.entities.Profile;
import com.skilldistillery.bandbuilder.entities.User;
import com.skilldistillery.bandbuilder.repositories.AddressRepository;
import com.skilldistillery.bandbuilder.repositories.ImageRepository;
import com.skilldistillery.bandbuilder.repositories.ProfileRepository;
import com.skilldistillery.bandbuilder.repositories.UserRepository;

public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileRepository profileRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private ImageRepository imageRepo;

	@Autowired
	private UserRepository userRepo;

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
	public Profile createProfile(ProfileDTO regInfo) {

		//Build Address
		Address address = new Address();
		address.setStreet(regInfo.getAddressStreet());
		address.setStreet2(regInfo.getAddressStreet2());
		address.setCity(regInfo.getAddressCity());
		address.setState(regInfo.getAddressState());
		address.setZip(regInfo.getAddressZip());
		address.setPhone(regInfo.getAddressPhone());
		address.setActive(true);
		address = addressRepo.saveAndFlush(address);
		
		//Build User  --- Do we need this? Or does AUTH build this?
		User user = new User();
		user.setUsername(regInfo.getUserUsername());
		user.setPassword(regInfo.getUserPassword());
		user.setRole(regInfo.getUserRole());
		user.setActive(true);
		user = userRepo.saveAndFlush(user);
		
		//Build Image
		Image image = new Image();
		image.setUrl(regInfo.getImageURL());
		image.setDescription(regInfo.getImageDescription());
		image.setAlt(regInfo.getImageAlt());
		image = imageRepo.saveAndFlush(image);
		
		//Build Profile
		Profile profile = new Profile();
		profile.setFirstName(regInfo.getProfileFirstName());
		profile.setLastName(regInfo.getProfileLastName());
		profile.setEmail(regInfo.getProfileEmail());
		profile.setAboutMe(regInfo.getProfileAboutMe());
		profile.setAddress(address);
		profile.setUser(user);
		profile.setImage(image);
		
		//Finally save and flush the profile so it updates.
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
			
			managed = profileRepo.saveAndFlush(managed);
		}
		
		return managed;
	}

	@Override
	public Boolean deleteProfileById(int id) {
		Boolean deleted = false;
		
		Optional<Profile> opt = profileRepo.findById(id);
		if (opt.isPresent()) {
			Profile managed = opt.get();
			managed.getUser().setActive(false);
			profileRepo.saveAndFlush(managed);
			deleted = true;
		}

		return deleted;
	}

}
