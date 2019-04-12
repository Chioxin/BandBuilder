package com.skilldistillery.bandbuilder.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.bandbuilder.entities.Image;
import com.skilldistillery.bandbuilder.repositories.ImageRepository;

public class ImageServiceImpl implements ImageService {
	
	@Autowired
	private ImageRepository imageRepo;

	@Override
	public Image getImageById(int id) {
		Image image = null;
		Optional<Image> opt = imageRepo.findById(id);
		
		if (opt.isPresent()) {
			image = opt.get();
		}
		
		return image;
	}

	@Override
	public Image createImage(Image image) {
		return imageRepo.saveAndFlush(image);
	}

	@Override
	public Image updateImage(int id, Image image) {
		Image managed = null;
		Optional<Image> opt = imageRepo.findById(id);
		
		if (opt.isPresent()) {
			managed = opt.get();
			managed.setDescription(image.getDescription());
			managed.setUrl(image.getUrl());
			managed.setAlt(image.getAlt());
			
			managed = imageRepo.saveAndFlush(managed);
		}
		return managed;
	}

	@Override
	public Boolean deleteImage(int id) {
		Boolean deleted = false;
		
		Optional<Image> opt = imageRepo.findById(id);
		if (opt.isPresent()) {
			Image image = opt.get();
			image.setActive(false);
			imageRepo.saveAndFlush(image);
			deleted = true;
		}
		
		return deleted;
	}

}
