package com.skilldistillery.bandbuilder.services;

import com.skilldistillery.bandbuilder.entities.User;

public interface UserService {

	public User show(String username, int uid);

	public User getUserByUsername(String username);
	
	public User getUserById(int uid);

	public User createUser(String username, User user);

	public User updateUserById(int uid, User user);

	public User destroyUser(String username, int uid);
}
