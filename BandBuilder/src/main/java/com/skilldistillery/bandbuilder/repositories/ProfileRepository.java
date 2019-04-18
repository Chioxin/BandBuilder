package com.skilldistillery.bandbuilder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bandbuilder.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	
	public Profile findByUserUsername(String username);

}
