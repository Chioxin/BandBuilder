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

import com.skilldistillery.bandbuilder.entities.UserInstrument;
import com.skilldistillery.bandbuilder.services.UserInstrumentService;

@RestController
@RequestMapping("api")
//@CrossOrigin({ "*", "http://localhost:4200" })
public class UserInstrumentController {

	@Autowired
	private UserInstrumentService userInstrumentSvc;

	@GetMapping(path = "profiles/{id}/userinstruments")
	public List<UserInstrument> index(@PathVariable("id") int id, HttpServletResponse response,
			HttpServletRequest request) {
		List<UserInstrument> userInstrumentList = userInstrumentSvc.getUserInstrumentByProfileId(id);
		if (userInstrumentList != null) {
			response.setStatus(200);
		} else {
			response.setStatus(404);
		}
		return userInstrumentList;
	}

	@GetMapping(path = "userinstruments/{id}")
	public UserInstrument select(@PathVariable("id") int id, HttpServletResponse response, HttpServletRequest request) {
		UserInstrument userInstrument = userInstrumentSvc.getUserInstrumentById(id);
		if (userInstrument != null) {
			response.setStatus(200);
		} else {
			response.setStatus(404);
		}
		return userInstrument;
	}

	@PostMapping(path = "userinstruments")
	public UserInstrument create(@RequestBody UserInstrument userInstrument, HttpServletResponse response,
			HttpServletRequest request) {
		UserInstrument newUserInstrument = userInstrumentSvc.createUserInstrument(userInstrument);
		if (userInstrument != null) {
			response.setStatus(201);
		} else {
			response.setStatus(400);
		}
		return newUserInstrument;
	}

	@PutMapping(path = "userinstruments/{id}")
	public UserInstrument update(@RequestBody UserInstrument userInstrument, @PathVariable int id,
			HttpServletRequest request, HttpServletResponse response) {
		UserInstrument updatedUserInstrument = userInstrumentSvc.updateUserInstrumentById(id, userInstrument);
		if (updatedUserInstrument != null) {
			response.setStatus(201);
		} else {
			response.setStatus(400);
		}
		return updatedUserInstrument;
	}

	@DeleteMapping(path = "userinstruments/{id}")
	public Boolean delete(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
		Boolean bool = userInstrumentSvc.deleteUserInstrumentById(id);
		if (bool == true) {
			response.setStatus(204);
		} else {
			response.setStatus(400);
		}
		return bool;
	}

}
