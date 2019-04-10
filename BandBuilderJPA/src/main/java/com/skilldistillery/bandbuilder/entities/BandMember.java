package com.skilldistillery.bandbuilder.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class BandMember {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

//	private Band band;

//	private Instrument instrument;

//	private Profile profile;

	private String description;

	private String experience;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "joined_at")
	private Date joinedAt;

	public BandMember() {
		super();
	}

}
