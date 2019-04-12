package com.skilldistillery.bandbuilder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bandbuilder.entities.BandMember;

public interface BandMemberRepository extends JpaRepository<BandMember, Integer> {

	public List<BandMember> getBandMembersByBandId(int id);
	public BandMember getBandMemberById(int id);
}
