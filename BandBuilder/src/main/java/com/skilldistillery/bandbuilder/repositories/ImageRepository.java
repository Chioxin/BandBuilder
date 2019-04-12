package com.skilldistillery.bandbuilder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bandbuilder.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {

}
