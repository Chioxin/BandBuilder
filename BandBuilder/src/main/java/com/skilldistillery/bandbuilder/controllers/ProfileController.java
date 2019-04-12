package com.skilldistillery.bandbuilder.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bandbuilder.datatransferobjects.RegistrationDTO;
import com.skilldistillery.bandbuilder.entities.Profile;
import com.skilldistillery.bandbuilder.services.ProfileService;

@RestController
@RequestMapping("api")
//@CrossOrigin({ "*", "http://localhost:4200" })
public class ProfileController {

	@Autowired
	private ProfileService profileSvc;
	
	@GetMapping("profiles")
	public List<Profile> getAllProfiles() {
		return profileSvc.getAllProfiles();
	}
	
	@GetMapping("profiles/{pid}")
	public Profile getProfileById(@PathVariable("pid") Integer id,
			HttpServletResponse resp) {
		
		Profile profile = profileSvc.getProfileById(id);
		
		if (profile == null) {
			resp.setStatus(404);
		}
		
		return profile;
	}
	
	@PostMapping("profiles")
	public Profile createProfile(@RequestBody RegistrationDTO regInfo,
			HttpServletResponse resp,
			HttpServletRequest req) {
		Profile profile = profileSvc.createProfile(regInfo);
		
		
		return profile;
	}
}
