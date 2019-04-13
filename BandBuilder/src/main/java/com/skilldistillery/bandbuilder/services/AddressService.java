package com.skilldistillery.bandbuilder.services;

import com.skilldistillery.bandbuilder.entities.Address;

public interface AddressService {
	
	public Address getAddressById (int id);
	public Address createAddress (Address address);
	public Address updateAddressById (int id, Address address);
	public Boolean deleteAddressById (int id);
	
}
