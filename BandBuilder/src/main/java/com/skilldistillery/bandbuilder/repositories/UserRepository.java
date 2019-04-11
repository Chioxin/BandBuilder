package com.skilldistillery.bandbuilder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bandbuilder.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
