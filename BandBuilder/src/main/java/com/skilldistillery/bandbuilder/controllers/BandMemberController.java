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

import com.skilldistillery.bandbuilder.datatransferobjects.BandMemberDTO;
import com.skilldistillery.bandbuilder.entities.BandMember;
import com.skilldistillery.bandbuilder.services.BandMemberService;

@RestController
@RequestMapping("api")
//@CrossOrigin({ "*", "http://localhost:4200" })
public class BandMemberController {
	
	@Autowired
	private BandMemberService bandMemberSvc;
	
	@GetMapping("bands/{id}/bandmembers")
	public List<BandMember> index(@PathVariable("id") Integer id) {
		return bandMemberSvc.getBandMembersByBandId(id);
	}
	
	@GetMapping("bandmembers/{id}")
	public BandMember selectBandMember(@PathVariable("id") Integer id,
			HttpServletResponse resp,
			HttpServletRequest req) {
		BandMember bandMember = bandMemberSvc.getBandMemberById(id);
		if (bandMember != null) {
			resp.setStatus(200);
		} else {
			resp.setStatus(404);
		}
		return bandMember;
	}
	
	@PostMapping("bandmembers")
	public BandMember createBandMember(@RequestBody BandMemberDTO bandMemberDTO,
			HttpServletResponse resp,
			HttpServletRequest req) {
		BandMember bandMember = bandMemberSvc.createBandMember(bandMemberDTO);
		if (bandMember != null) {
			resp.setStatus(201);
		} else {
			resp.setStatus(400);
		}
		return bandMember;
	}
	
	@PutMapping("bandmembers/{id}")
	public BandMember updateBandMember(@PathVariable("id") Integer id, 
			@RequestBody BandMember bandMember,
			HttpServletResponse resp) {
		bandMember = bandMemberSvc.updateBandMember(id, bandMember);
		if (bandMember != null) {
			resp.setStatus(201);
		} else {
			resp.setStatus(400);
		}
		return bandMember;
	}

	@DeleteMapping("bandmembers/{id}")
	public void deleteBandMember(@PathVariable("id") Integer id,
			HttpServletResponse resp) {
		if (bandMemberSvc.deleteBandMember(id)) {
			resp.setStatus(204);
		} else {
			resp.setStatus(400);
		}
	}
	
}
