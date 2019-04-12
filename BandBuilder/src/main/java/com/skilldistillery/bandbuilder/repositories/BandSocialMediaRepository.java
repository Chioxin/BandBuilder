package com.skilldistillery.bandbuilder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bandbuilder.entities.BandSocialMedia;

public interface BandSocialMediaRepository extends JpaRepository<BandSocialMedia, Integer> {
	
	public List<BandSocialMedia> findByBandId (int id);

}
