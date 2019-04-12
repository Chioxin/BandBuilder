package com.skilldistillery.bandbuilder.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bandbuilder.datatransferobjects.BandDTO;
import com.skilldistillery.bandbuilder.entities.Band;
import com.skilldistillery.bandbuilder.repositories.BandRepository;
import com.skilldistillery.bandbuilder.services.BandService;

@RestController
@RequestMapping("api")
//@CrossOrigin({ "*", "http://localhost:4200" })
public class BandController {
	
	@Autowired
	private BandService bandSvc;
	@Autowired
	private BandRepository bandRepo;
	
	// address svc ************ uncomment when address service is created
	//	@Autowired
	//	private AddressService addressSvc;
	
	// addres repo ************ uncomment when address repository is created
	//	@Autowired
	//	private BandRepository bandRepo;
	
	// band member svc ************ uncomment when band member service is created
	//	@Autowired
	//	private BandMemberService bandMemberSvc;
	
	// band member repo ************ uncomment when band member repository is created
	//	@Autowired
	//	private BandMemberRepository bandMemberRepo;
	
	// band social media svc ************ uncomment when band social media service is created
	//	@Autowired
	//	private BandSocialMediaRService bandSocialMediaRepo;
	
	// band social media repo ************ uncomment when band social media repository is created
	//	@Autowired
	//	private BandSocialMediaRepository bandSocialMediaRepo;
	
	@GetMapping("bands")
	public List<Band> index(){
		return bandSvc.getAllBands();
	}
	
	@GetMapping("bands/{id}")
	public Band select(@PathVariable("id") int id, 
			HttpServletResponse response, 
			HttpServletRequest request) {
		Band band = bandSvc.getBandById(id);
		if(band != null) {
			response.setStatus(200);
		} else {
			response.setStatus(404);
		}
		return band;
	}
	
	@GetMapping("profiles/{id}/bands")
	public List<Band> getAllBandsByProfileId(@PathVariable("id") int id, 
			HttpServletResponse response, 
			HttpServletRequest request) {
			List<Band> bandList = bandSvc.getAllBandsByProfileId(id);
			if(bandList != null) {
				response.setStatus(200);
			} else {
				response.setStatus(404);
			}
			return bandList;
	}
	
	@PostMapping("bands")
	public Band create(@RequestBody Band band, 
			HttpServletResponse response,
			HttpServletRequest request) {
		Band newBand = bandSvc.createBand(band);
		if(band != null) {
			response.setStatus(201);
		} else {
			response.setStatus(400);
		}
		return newBand;
	}
	
	@PutMapping(path = "bands")
	public Band update(@RequestBody BandDTO bandDTO,
			@PathVariable int id,
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		return null;
	}

}
