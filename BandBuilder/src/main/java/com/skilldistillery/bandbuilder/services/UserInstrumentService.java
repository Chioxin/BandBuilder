package com.skilldistillery.bandbuilder.services;

import java.util.List;

import com.skilldistillery.bandbuilder.entities.UserInstrument;

public interface UserInstrumentService {

	List<UserInstrument> getUserInstrumentByProfileId(int id);
	
	UserInstrument getUserInstrumentById(int id);
	
	UserInstrument createUserInstrument(UserInstrument userInstrument);
	
	UserInstrument updateUserInstrumentById(int id, UserInstrument userInstrument);
	
	Boolean deleteUserInstrumentById(int id);
	
}
