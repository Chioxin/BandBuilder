package com.skilldistillery.bandbuilder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.bandbuilder.entities.Band;
import com.skilldistillery.bandbuilder.entities.Profile;
import com.skilldistillery.bandbuilder.repositories.BandRepository;
import com.skilldistillery.bandbuilder.repositories.ProfileRepository;

public class BandServiceImpl implements BandService {

	@Autowired
	private BandRepository bandRepo;

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
	public Band createBand(Band band) {
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
			managed.setUpdatedAt(band.getUpdatedAt());
			managed.setCreatedAt(band.getCreatedAt());
			managed.setId(band.getId());
//			managed.setImage(band.getImage());	uncomment when database is changed from a list of images to a single image
			bandRepo.saveAndFlush(managed);
		}
		return band;
	}

	@Override
	public Boolean deleteBandById(int id) {
		return null;
	}

}
