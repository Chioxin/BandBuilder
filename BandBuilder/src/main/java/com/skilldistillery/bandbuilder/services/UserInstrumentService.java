package com.skilldistillery.bandbuilder.services;

import java.util.List;

import com.skilldistillery.bandbuilder.entities.UserInstrument;

public interface UserInstrumentService {

	public List<UserInstrument> getUserInstrumentsByProfileId(int id);
	
	public UserInstrument getUserInstrumentById(int id);
	
	public UserInstrument createUserInstrument(UserInstrument userInstrument);
	
	public UserInstrument updateUserInstrumentById(int id, UserInstrument userInstrument);
	
	public Boolean deleteUserInstrumentById(int id);
	
}
