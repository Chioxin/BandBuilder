package com.skilldistillery.bandbuilder.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserInstrument {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	private Profile profile;
	
//	private Instrument instrument;
	
	private String experience;
	
	private String description;

}
