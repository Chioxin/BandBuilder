package com.skilldistillery.bandbuilder.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.bandbuilder.entities.Address;
import com.skilldistillery.bandbuilder.repositories.AddressRepository;

public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepo;
	
	@Override
	public Address getAddressById(int id) {
		Address address = null;
		
		Optional<Address> opt = addressRepo.findById(id);
		if (opt.isPresent()) {
			address = opt.get();
		}
		
		return address;
	}

	@Override
	public Address createAddress(Address address) {
		return addressRepo.saveAndFlush(address);
	}

	@Override
	public Address updateAddressById(int id, Address address) {
		Address managed = null;
		Optional<Address> opt = addressRepo.findById(id);
		
		if (opt.isPresent()) {
			managed = opt.get();
			managed.setStreet(address.getStreet());
			managed.setStreet2(address.getStreet2());
			managed.setCity(address.getCity());
			managed.setState(address.getState());
			managed.setZip(address.getZip());
			managed.setPhone(address.getPhone());
			managed.setActive(address.isActive());
			
			addressRepo.saveAndFlush(managed);
		}

		return managed;
	}

	@Override
	public Boolean deleteAddressById(int id) {
		Boolean deleted = false;
		
		Optional<Address> opt = addressRepo.findById(id);
		if (opt.isPresent()) {
			Address managed = opt.get();
			managed.setActive(false);
			addressRepo.saveAndFlush(managed);
			deleted = true;
		}
		
		return deleted;
	}

}
