package com.skilldistillery.bandbuilder.services;

import com.skilldistillery.bandbuilder.entities.Image;

public interface ImageService {
	
	public Image getImageById(int id);
	public Image createImage(Image image);
	public Image updateImage(int id, Image image);
	public Boolean deleteImage(int id);

}
