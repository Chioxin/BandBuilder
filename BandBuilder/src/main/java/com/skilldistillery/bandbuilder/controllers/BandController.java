package com.skilldistillery.bandbuilder.controllers;

import java.util.List;

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

import com.skilldistillery.bandbuilder.entities.Band;
import com.skilldistillery.bandbuilder.services.BandService;

@RestController
@RequestMapping("api")
//@CrossOrigin({ "*", "http://localhost:4200" })
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
	
	@PostMapping("bands")
	public Band create(@RequestBody Band band, 
			HttpServletResponse response) {
		Band newBand = bandSvc.createBand(band);
		if(band != null) {
			response.setStatus(201);
		} else {
			response.setStatus(400);
		}
		return newBand;
	}
	
	@PutMapping(path = "bandmembers/{id}")
	public Band update(@RequestBody Band updatedBand, 
			@PathVariable("id") Integer id,
			HttpServletResponse resp) {
		updatedBand = bandSvc.updateBandById(id, updatedBand);
		if (updatedBand != null) {
			resp.setStatus(201);
		} else {
			resp.setStatus(400);
		}
		return updatedBand;
	}
	
	@DeleteMapping("bandmembers/{id}")
	public void deleteBand(@PathVariable("id") Integer id,
			HttpServletResponse resp) {
		if (bandSvc.deleteBandById(id)) {
			resp.setStatus(204);
		} else {
			resp.setStatus(400);
		}
	}
	
}
