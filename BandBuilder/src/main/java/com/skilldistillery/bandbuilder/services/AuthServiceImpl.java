package com.skilldistillery.bandbuilder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skilldistillery.bandbuilder.entities.User;
import com.skilldistillery.bandbuilder.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public User register(User user) {
		if (user == null) {
			return null;
		}
		String password = encoder.encode(user.getPassword());
		user.setPassword(password);
		user.setEnabled(true);
		user.setActive(true);
		user.setRole("standard");
		
		userRepository.saveAndFlush(user);
		
		return user;
	}

//	public User authenticateUser(User user) throws NoResultException {
//		// find the User by username/userId (a unique field)
//		User managedUser = userService.getUserByUsername(user.getUsername());
//
//		if (encoder.matches(user.getPassword(), managedUser.getPassword())) {
//			return managedUser;
//		}
//		return null;
//	}

}
