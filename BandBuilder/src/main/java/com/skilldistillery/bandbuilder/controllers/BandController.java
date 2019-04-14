package com.skilldistillery.bandbuilder.controllers;

import java.util.List;

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

import com.skilldistillery.bandbuilder.datatransferobjects.BandDTO;
import com.skilldistillery.bandbuilder.entities.Band;
import com.skilldistillery.bandbuilder.services.BandService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4220" })
public class BandController {
	
	//	band svc
	@Autowired
	private BandService bandSvc;
	
	@GetMapping("bands")
	public List<Band> index(){
		return bandSvc.getAllBands();
	}
	
	@GetMapping("bands/{id}")
	public Band select(@PathVariable("id") int id, 
			HttpServletResponse response) {
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
			HttpServletResponse response) {
			List<Band> bandList = bandSvc.getAllBandsByProfileId(id);
			if(bandList != null) {
				response.setStatus(200);
			} else {
				response.setStatus(404);
			}
			return bandList;
	}
	
	@PostMapping("profiles/{id}/bands")
	public Band createBand(@PathVariable("id") int id,
			@RequestBody BandDTO dto, 
			HttpServletResponse response) {
		Band newBand = bandSvc.createBand(dto, id);
		if(newBand != null) {
			response.setStatus(201);
		} else {
			response.setStatus(400);
		}
		return newBand;
	}
	
	@PutMapping(path = "profiles/{id}/bands")
	public Band updateBand(@RequestBody Band band, 
			@PathVariable("id") Integer id,
			HttpServletResponse response) {
		Band updatedBand = bandSvc.updateBandById(id, band);
		if (updatedBand != null) {
			response.setStatus(201);
		} else {
			response.setStatus(400);
		}
		return updatedBand;
	}
	
	@DeleteMapping("bands/{id}")
	public void deleteBand(@PathVariable("id") Integer id,
			HttpServletResponse resp) {
		if (bandSvc.deleteBandById(id)) {
			resp.setStatus(204);
		} else {
			resp.setStatus(400);
		}
	}
	
}
