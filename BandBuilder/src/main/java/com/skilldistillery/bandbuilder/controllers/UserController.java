package com.skilldistillery.bandbuilder.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bandbuilder.entities.User;
import com.skilldistillery.bandbuilder.repositories.UserRepository;
import com.skilldistillery.bandbuilder.services.UserService;

@RestController
@RequestMapping("api")
//@CrossOrigin({ "*", "http://localhost:4220" })
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(path="todos", method=RequestMethod.GET)
	public User index(HttpServletRequest req, HttpServletResponse res, Principal principal) {
	  return userService.getUserByUsername(principal.getName());
	}

}
