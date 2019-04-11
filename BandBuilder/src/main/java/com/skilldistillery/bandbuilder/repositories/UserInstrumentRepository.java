package com.skilldistillery.bandbuilder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bandbuilder.entities.UserInstrument;

public interface UserInstrumentRepository extends JpaRepository<UserInstrument, Integer> {

}
