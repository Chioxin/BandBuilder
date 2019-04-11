package com.skilldistillery.bandbuilder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bandbuilder.entities.BandMember;

public interface BandMemberRepository extends JpaRepository<BandMember, Integer> {

}
