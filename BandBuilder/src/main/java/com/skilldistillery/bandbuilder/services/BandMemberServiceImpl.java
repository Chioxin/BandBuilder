package com.skilldistillery.bandbuilder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bandbuilder.datatransferobjects.BandMemberDTO;
import com.skilldistillery.bandbuilder.entities.Band;
import com.skilldistillery.bandbuilder.entities.BandMember;
import com.skilldistillery.bandbuilder.entities.Instrument;
import com.skilldistillery.bandbuilder.entities.Profile;
import com.skilldistillery.bandbuilder.repositories.BandMemberRepository;
import com.skilldistillery.bandbuilder.repositories.BandRepository;
import com.skilldistillery.bandbuilder.repositories.ProfileRepository;

@Service
public class BandMemberServiceImpl implements BandMemberService {
	
	@Autowired
	private BandMemberRepository bandMemberRepo;
	
	@Autowired
	private BandRepository bandRepo;
	
	@Autowired
	private ProfileRepository profileRepo;

	@Override
	public List<BandMember> getBandMembersByBandId(int id) {
		return bandMemberRepo.getBandMembersByBandId(id);
	}
	
	public List<BandMember> getBandMembersByProfileId(int id) {
		return bandMemberRepo.findByProfileId(id);
	}

	@Override
	public BandMember getBandMemberById(int id) {
		return bandMemberRepo.getBandMemberById(id);
	}

	@Override
	public BandMember createBandMember(BandMemberDTO dto) {
		
		// Build Band
		Band band = new Band();
		
		band.setAboutUs(dto.getBand_aboutUs());
		band.setActive(true);
		band.setAddress(dto.getBand_address());
		band.setBandMembers(dto.getBand_bandMembers());
		band.setBandSocialMedias(dto.getBand_bandSocialMedias());
		band.setEmail(dto.getBand_email());
		band.setEvents(dto.getBand_events());
		band.setGenre(dto.getBand_genre());
		band.setImage(dto.getBand_image());
		band.setLeader(dto.getBand_leader());
		band.setName(dto.getBand_name());
		band.setTimeCommitment(dto.getBand_timeCommitment());
		
		band = bandRepo.saveAndFlush(band);
		
		// Build Instrument
		Instrument instrument = new Instrument();
		
		instrument.setDescription(dto.getInstrument_description());
		instrument.setActive(true);
		instrument.setApproved(dto.isInstrument_approved());
		instrument.setImage(dto.getInstrument_image());
		instrument.setName(dto.getInstrument_name());
		
//		instrument = instrumentRepo.saveAndFlush(instrument);		*********** uncomment when instrumentRepo is finished
		
		// Build Profile
		Profile profile = new Profile();
		
		profile.setAboutMe(dto.getProfile_aboutMe());
		profile.setActive(true);
		profile.setAddress(dto.getProfile_address());
		profile.setBandMembers(dto.getProfile_bandMembers());
		profile.setBands(dto.getProfile_bands());
		profile.setEmail(dto.getProfile_email());
		profile.setFirstName(dto.getProfile_firstName());
		profile.setImage(dto.getProfile_image());
		profile.setInstruments(dto.getProfile_instruments());
		profile.setLastName(dto.getProfile_lastName());
		profile.setUser(dto.getProfile_user());
		
		profile = profileRepo.saveAndFlush(profile);
		
		// Build BandMember
		BandMember bandMember = new BandMember();
		
		bandMember.setActive(true);
		bandMember.setBand(band);
		bandMember.setDescription(dto.getBandMember_description());
		bandMember.setExperience(dto.getBandMember_experience());
		bandMember.setInstrument(instrument);
		bandMember.setJoinedAt(dto.getBandMember_joinedAt());
		bandMember.setProfile(profile);
		
		bandMemberRepo.saveAndFlush(bandMember);
		
		return bandMember;
	}

	@Override
	public BandMember updateBandMember(int id, BandMember bandMember) {
		BandMember managed = bandMemberRepo.getBandMemberById(id);
		
		managed.setActive(bandMember.isActive());
		managed.setBand(bandMember.getBand());
		managed.setCreatedAt(bandMember.getCreatedAt());
		managed.setDescription(bandMember.getDescription());
		managed.setExperience(bandMember.getExperience());
		managed.setInstrument(bandMember.getInstrument());
		managed.setJoinedAt(bandMember.getJoinedAt());
		managed.setProfile(bandMember.getProfile());
		bandMemberRepo.saveAndFlush(managed);
		
		return managed;
	}

	@Override
	public Boolean deleteBandMember(int id) {
		BandMember bandMember = bandMemberRepo.getBandMemberById(id);
		Boolean deleted = false;
		if(bandMember != null) {
			deleted = true;
			bandMember.setActive(false);
		}
		return deleted;
	}

}
