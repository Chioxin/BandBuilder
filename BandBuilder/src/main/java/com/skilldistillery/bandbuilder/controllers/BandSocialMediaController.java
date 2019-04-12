package com.skilldistillery.bandbuilder.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bandbuilder.entities.BandSocialMedia;
import com.skilldistillery.bandbuilder.services.BandSocialMediaService;

@RestController
@RequestMapping("api")
//@CrossOrigin({ "*", "http://localhost:4200" })
public class BandSocialMediaController {
	
	@Autowired
	private BandSocialMediaService bandSocialMediaSvc;
	
	@GetMapping("bands/{bid}/bandsocialmedia")
	public List<BandSocialMedia> getBandSocialMediaByBandId (@PathVariable("bid") Integer id,
			HttpServletResponse resp) {
		
		List<BandSocialMedia> bsms = bandSocialMediaSvc.getBandSocialMediaByBandId(id);
		
		if (bsms == null) {
			resp.setStatus(404);
		}
		
		return bsms;
	}
	
	@GetMapping("bandsocialmedia/{bid}")
	public BandSocialMedia getBandSocialMediaById (@PathVariable("bid") Integer id,
			HttpServletResponse resp) {
		BandSocialMedia bsm = bandSocialMediaSvc.getBandSocialMediaById(id);
		
		if (bsm == null) {
			resp.setStatus(404);
		}
		
		return bsm;
	}
	
	@PostMapping("bandsocialmedia")
	public BandSocialMedia createBandSocialMedia (@RequestBody BandSocialMedia bsm,
			HttpServletResponse resp,
			HttpServletRequest req) {
		
		bsm = bandSocialMediaSvc.createBandSocialMedia(bsm);
		
		if (bsm != null) {
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/");
			url.append(bsm.getId());
			resp.setHeader("Location", url.toString());
		} else {
			resp.setStatus(400);
		}
		
		
		return bsm;
	}
	
	@PutMapping("bandsocialmedia/{bid}")
	public BandSocialMedia updateBandSocialMedia (@RequestBody BandSocialMedia updatedBandSocialMedia,
			@PathVariable("bid") Integer id,
			HttpServletResponse resp) {
		
		updatedBandSocialMedia = bandSocialMediaSvc.updateBandSocialMediaById(id, updatedBandSocialMedia);
		
		if (updatedBandSocialMedia != null) {
			resp.setStatus(201);
		} else {
			resp.setStatus(400);
		}
		
		return updatedBandSocialMedia;
	}
	
	@DeleteMapping("bandsocialmedia/{bid}")
	public void deleteBandSocialMedia (@PathVariable Integer id,
			HttpServletResponse resp) {
		
		if (bandSocialMediaSvc.deleteBandSocialMediaById(id)) {
			resp.setStatus(204);
		} else {
			resp.setStatus(400);
		}
		
	}

}
