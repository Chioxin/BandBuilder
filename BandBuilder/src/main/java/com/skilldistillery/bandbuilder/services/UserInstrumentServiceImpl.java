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
			managed.setDescription(userInstrument.getDescription());
			managed.setExperience(userInstrument.getExperience());
			return userInstrumentRepo.saveAndFlush(managed);
		} else {
			return null;
		}
	}

	@Override
	public Boolean deleteUserInstrumentById(int id) {
		Boolean deleted = false;
		
		Optional<UserInstrument> opt = userInstrumentRepo.findById(id);
		if (opt.isPresent()) {
			UserInstrument managed = opt.get();
			managed.setActive(false);
			userInstrumentRepo.saveAndFlush(managed);
			deleted = true;
		}
		return deleted;
	}

}
