package com.skilldistillery.bandbuilder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bandbuilder.datatransferobjects.BandDTO;
import com.skilldistillery.bandbuilder.entities.Address;
import com.skilldistillery.bandbuilder.entities.Band;
import com.skilldistillery.bandbuilder.entities.BandMember;
import com.skilldistillery.bandbuilder.entities.BandSocialMedia;
import com.skilldistillery.bandbuilder.entities.Profile;
import com.skilldistillery.bandbuilder.repositories.BandMemberRepository;
import com.skilldistillery.bandbuilder.repositories.BandRepository;
import com.skilldistillery.bandbuilder.repositories.ProfileRepository;

@Service
public class BandServiceImpl implements BandService {

	@Autowired
	private BandRepository bandRepo;
	
	@Autowired
	private BandMemberRepository bandMemberRepo;

	@Autowired
	private ProfileRepository profileRepo;

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
	public Band createBand(BandDTO dto) {
		
		// Build Address
		Address address = new Address();
		
		address.setActive(true);
		address.setCity(dto.getAddress_city());
		address.setPhone(dto.getAddress_phone());
		address.setState(dto.getAddress_state());
		address.setStreet(dto.getAddress_street());
		address.setStreet2(dto.getAddress_street2());
		address.setZip(dto.getAddress_zip());
		
//		address = addressRepo.saveAndFlush(address); ******** uncomment when address service is made
		
		// Build Band Members
		BandMember bandMember = new BandMember();
		
		bandMember.setActive(true);
		bandMember.setBand(dto.getBandMember_band());
		bandMember.setDescription(dto.getBandMember_description());
		bandMember.setExperience(dto.getBandMember_experience());
		bandMember.setInstrument(dto.getBandMember_instrument());
		bandMember.setJoinedAt(dto.getBandMember_joinedAt());
		bandMember.setProfile(dto.getBandMember_profile());
		
		bandMember = bandMemberRepo.saveAndFlush(bandMember);
		
		// Build Band Social Media
		BandSocialMedia bandSocialMedia = new BandSocialMedia();
		
		bandSocialMedia.setActive(true);
		bandSocialMedia.setBand(dto.getBandSocialMedia_band());
		bandSocialMedia.setSocialMedia(dto.getBandSocialMedia_socialMedia());
		
		
		return null;
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
			managed.setUpdatedAt(band.getUpdatedAt());
			managed.setCreatedAt(band.getCreatedAt());
			managed.setId(band.getId());
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
