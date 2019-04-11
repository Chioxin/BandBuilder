package com.skilldistillery.bandbuilder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bandbuilder.entities.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument, Integer> {

}
