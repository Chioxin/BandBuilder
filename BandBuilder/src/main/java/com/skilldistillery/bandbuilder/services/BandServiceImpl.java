package com.skilldistillery.bandbuilder.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bandbuilder.datatransferobjects.BandDTO;
import com.skilldistillery.bandbuilder.entities.Address;
import com.skilldistillery.bandbuilder.entities.Band;
import com.skilldistillery.bandbuilder.entities.BandMember;
import com.skilldistillery.bandbuilder.entities.BandSocialMedia;
import com.skilldistillery.bandbuilder.entities.Image;
import com.skilldistillery.bandbuilder.entities.Profile;
import com.skilldistillery.bandbuilder.repositories.AddressRepository;
import com.skilldistillery.bandbuilder.repositories.BandRepository;
import com.skilldistillery.bandbuilder.repositories.ImageRepository;
import com.skilldistillery.bandbuilder.repositories.ProfileRepository;

@Service
public class BandServiceImpl implements BandService {

	@Autowired
	private BandRepository bandRepo;
	
//	@Autowired
//	private BandMemberRepository bandMemberRepo;

	@Autowired
	private ProfileRepository profileRepo;
	
//	@Autowired
//	private BandSocialMediaRepository bandSocialMediaRepo;
	
	@Autowired
	private ImageRepository imageRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
//	@Autowired
//	private InstrumentRepository instrumentRepo;

	@Override
	public List<Band> getAllBands() {
		return bandRepo.findAll();
	}

	@Override
	public Band getBandById(int id) {
		Optional<Band> optional = bandRepo.findById(id);
		Band band = null;
		if (optional.isPresent()) {
			band = optional.get();
		}
		return band;
	}

	@Override
	public List<Band> getAllBandsByProfileId(int id) {
		Optional<Profile> optional = profileRepo.findById(id);
		List<Band> bandList = null;
		if (optional.isPresent()) {
			Profile profile = optional.get();
			bandList = profile.getBands();
		}
		return bandList;
	}

	@Override
	public Band createBand(BandDTO dto, int id) {
		
	// Build Leader
	Optional<Profile> profile = profileRepo.findById(id);
	Profile leader = new Profile();
	if (profile.isPresent()) {
		leader = profile.get();
	}
	
	// Build Address
	Address address = new Address();
	
	// Set Address fields
	address.setActive(true);
	address.setCity(dto.getAddressCity());
	address.setPhone(dto.getAddressPhone());
	address.setState(dto.getAddressState());
	address.setStreet(dto.getAddressStreet());
	address.setStreet2(dto.getAddressStreet2());
	address.setZip(dto.getAddressZip());
	
	// Save and flush address
	address = addressRepo.saveAndFlush(address);
	
	// Build Band Member
	BandMember bandMember = new BandMember();
	
	// Build list of Band Members
	List<BandMember> bandMembers = new ArrayList<BandMember>();
	bandMembers.add(bandMember);
	
	// Build Band Social Media
	BandSocialMedia bandSocialMedia = new BandSocialMedia();
	
	// Build List of Social Media
	List<BandSocialMedia> bandSocialMedias = new ArrayList<BandSocialMedia>();
	bandSocialMedias.add(bandSocialMedia);
	
	// Set Default Image
	Optional<Image> image = imageRepo.findById(1);
	Image defaultImage = new Image();
	
	if (image.isPresent()) {
		defaultImage = image.get();
	}
	
	// Save and flush image
	imageRepo.saveAndFlush(defaultImage);
	
	// Build Band
	Band band = new Band();
	
	// Set Fields
	band.setAboutUs(dto.getBandAboutUs());
	band.setActive(true);
	band.setEmail(dto.getBandBandEmail());
	band.setGenre(dto.getBandGenre());
	band.setName(dto.getBandName());
//	band.setTimeCommitment(dto.getBandTimeCommitment());
	
	// Build TimeCommitment String
	String bandOneLabel = dto.getBandOneLabel();
	int bandOneField = dto.getBandOneField();
	String bandTwoLabel = dto.getBandTwoLabel();
	
	band.setTimeCommitment(bandOneField + " " + bandOneLabel + "per " +  bandTwoLabel);

	// Set Objects
	band.setAddress(address);
	band.setBandMembers(bandMembers);
	band.setBandSocialMedias(bandSocialMedias);
	band.setImage(defaultImage);
	band.setLeader(leader);
	
	
	//Finally save and flush the profile so it updates.
	return bandRepo.saveAndFlush(band);
}

	@Override
	public Band updateBandById(int id, Band band) {
		Optional<Band> optional = bandRepo.findById(id);
		Band managed = null;
		if (optional.isPresent()) {
			managed = optional.get();
			managed.setAboutUs(band.getAboutUs());
			managed.setEmail(band.getEmail());
			managed.setGenre(band.getGenre());
			managed.setLeader(band.getLeader());
			managed.setName(band.getName());
			managed.setTimeCommitment(band.getTimeCommitment());
			managed.setImage(band.getImage());
			bandRepo.saveAndFlush(managed);
		}
		return band;
	}

	@Override
	public Boolean deleteBandById(int id) {
		Boolean deleted = false;
		Optional<Band> opt = bandRepo.findById(id);
		if (opt.isPresent()) {
			Band band = opt.get();
			band.setActive(false);
			deleted = true;
		}
		return deleted;
	}

}
