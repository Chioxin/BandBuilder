package com.skilldistillery.bandbuilder.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bandbuilder.entities.User;
import com.skilldistillery.bandbuilder.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User show(String username, int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = null;
		Optional<User> opt = userRepository.findByUsername(username);
		if (opt.isPresent()) {
			if (opt.get().getUsername().equals(username)) {
				user = opt.get();
			}

		}
		return user;
	}

	@Override
	public User getUserById(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUser(String username, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUserById(int uid, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User destroyUser(String username, int uid) {
		// TODO Auto-generated method stub
		return null;
	}

}
