package com.skilldistillery.bandbuilder.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Instrument {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	
	private boolean approved;
	
//	private Image image;
	
	private String description;

	public Instrument() {
		super();
	}

}
