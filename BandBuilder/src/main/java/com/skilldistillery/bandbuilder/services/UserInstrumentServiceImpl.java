package com.skilldistillery.bandbuilder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bandbuilder.entities.UserInstrument;
import com.skilldistillery.bandbuilder.repositories.UserInstrumentRepository;

@Service
public class UserInstrumentServiceImpl implements UserInstrumentService {

	@Autowired
	private UserInstrumentRepository userInstrumentRepo;

	@Override
	public List<UserInstrument> getUserInstrumentsByProfileId(int id) {
		return userInstrumentRepo.getUserInstrumentByProfileId(id);
	}

	@Override
	public UserInstrument getUserInstrumentById(int id) {
		Optional<UserInstrument> optional = userInstrumentRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	@Override
	public UserInstrument createUserInstrument(UserInstrument userInstrument) {
		return userInstrumentRepo.saveAndFlush(userInstrument);
	}

	@Override
	public UserInstrument updateUserInstrumentById(int id, UserInstrument userInstrument) {
		Optional<UserInstrument> optional = userInstrumentRepo.findById(id);
		if (optional.isPresent()) {
			UserInstrument managed = optional.get();
			userInstrument.setDescription(managed.getDescription());
			userInstrument.setExperience(managed.getExperience());
			return userInstrumentRepo.saveAndFlush(userInstrument);
		} else {
			return null;
		}
	}

	@Override
	public Boolean deleteUserInstrumentById(int id) {
		return null;
	}

}
