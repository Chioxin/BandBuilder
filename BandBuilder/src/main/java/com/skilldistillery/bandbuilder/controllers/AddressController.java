package com.skilldistillery.bandbuilder.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bandbuilder.entities.Address;
import com.skilldistillery.bandbuilder.services.AddressService;

@RestController
@RequestMapping("api")
//@CrossOrigin({ "*", "http://localhost:4200" })
public class AddressController {
	
	@Autowired
	private AddressService addressSvc;
	
	@GetMapping("addresses/{aid}")
	public Address getAddressById (@PathVariable("aid") Integer id,
			HttpServletResponse resp) {
		
		Address address = addressSvc.getAddressById(id);
		
		if (address == null) {
			resp.setStatus(404);
		}
		
		return address;
	}
	
	@PostMapping("addresses")
	public Address createAddress (@RequestBody Address address,
			HttpServletResponse resp,
			HttpServletRequest req) {
		
		address = addressSvc.createAddress(address);
		
		if (address != null) {
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/");
			url.append(address.getId());
			resp.setHeader("Location", url.toString());
		} else {
			resp.setStatus(400);
		}
		
		return address;
	}
	
	@PutMapping("addresses/{aid}")
	public Address createAddressById (@RequestBody Address updatedAddress, @PathVariable Integer id,
			HttpServletResponse resp) {
		
		updatedAddress = addressSvc.updateAddressById(id, updatedAddress);
		
		if (updatedAddress != null) {
			resp.setStatus(201);
		} else {
			resp.setStatus(400);
		}
		
		return updatedAddress;
	}
	
	@DeleteMapping("addresses/{aid}")
	public void deleteAddressById (@PathVariable Integer id,
			HttpServletResponse resp) {
		
		if (addressSvc.deleteAddressById(id)) {
			resp.setStatus(204);
		} else {
			resp.setStatus(400);
		}
	}

}
