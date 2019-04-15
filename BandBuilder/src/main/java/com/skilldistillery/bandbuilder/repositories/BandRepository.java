package com.skilldistillery.bandbuilder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bandbuilder.entities.Band;
import com.skilldistillery.bandbuilder.entities.Profile;

public interface BandRepository extends JpaRepository<Band, Integer> {
	
}
