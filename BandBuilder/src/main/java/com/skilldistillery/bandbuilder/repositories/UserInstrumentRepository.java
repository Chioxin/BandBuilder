package com.skilldistillery.bandbuilder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bandbuilder.entities.UserInstrument;

public interface UserInstrumentRepository extends JpaRepository<UserInstrument, Integer> {
	
	List<UserInstrument> getUserInstrumentByProfileId(int id);
	
}
