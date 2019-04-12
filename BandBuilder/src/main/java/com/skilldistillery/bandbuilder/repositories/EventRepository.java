package com.skilldistillery.bandbuilder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bandbuilder.entities.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
