package com.skilldistillery.bandbuilder.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bandbuilder.entities.Image;
import com.skilldistillery.bandbuilder.services.ImageService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4220" })
public class ImageController {
	
	@Autowired
	private ImageService imageSvc;
	
	@GetMapping("images/{iid}")
	public Image getImageById(@PathVariable("iid") Integer id,
			HttpServletResponse resp) {
		
		Image image = imageSvc.getImageById(id);
		
		if (image == null) {
			resp.setStatus(404);
		}
		
		return image;
	}
	
	@PostMapping("images")
	public Image createImage(@RequestBody Image image,
			HttpServletResponse resp,
			HttpServletRequest req) {
		
		Image newImage = imageSvc.createImage(image);
		
		if (newImage != null) {
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/");
			url.append(image.getId());
			resp.setHeader("Location", url.toString());
		} else {
			resp.setStatus(400);
		}
		
		return newImage;
	}
	
	@PutMapping("images/{iid}")
	public Image updateImageById(@PathVariable("iid") Integer id, @RequestBody Image updatedImage,
			HttpServletResponse resp) {
		updatedImage = imageSvc.updateImage(id, updatedImage);
		
		if (updatedImage != null) {
			resp.setStatus(201);
		} else {
			resp.setStatus(400);
		}
		
		return updatedImage;
	}
	
	@DeleteMapping("images/{iid}")
	public void deleteImageById(@PathVariable("iid") Integer id,
			HttpServletResponse resp) {
		
		if (imageSvc.deleteImage(id)) {
			resp.setStatus(204);
		} else {
			resp.setStatus(400);
		}
	}

}
