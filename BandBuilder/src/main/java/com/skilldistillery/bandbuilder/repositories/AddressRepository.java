package com.skilldistillery.bandbuilder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bandbuilder.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
