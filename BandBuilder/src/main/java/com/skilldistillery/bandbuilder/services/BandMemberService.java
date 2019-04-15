package com.skilldistillery.bandbuilder.services;

import java.util.List;

import com.skilldistillery.bandbuilder.datatransferobjects.BandMemberDTO;
import com.skilldistillery.bandbuilder.entities.BandMember;

public interface BandMemberService {

	public List<BandMember> getBandMembersByBandId(int id);
	public List<BandMember> getBandMembersByProfileId(int id);
	public BandMember getBandMemberById(int id);
	public BandMember createBandMember(BandMemberDTO bandMemberDTO);
	public BandMember updateBandMember(int id, BandMember bandMember);
	public Boolean deleteBandMember(int id);
	
}
