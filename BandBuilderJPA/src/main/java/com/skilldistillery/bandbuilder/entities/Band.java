package com.skilldistillery.bandbuilder.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Band {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name="about_us")
	private String aboutUs;
	
	private String genre;
	
	private List<BandMember> bandMembers;
	
	private Address address;
	
	private Profile leader;
	
	private String email;
	
	@Column(name="time_commitment")
	private String timeCommitment;
	
	@Column(name="created_at")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name="updated_at")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
//	private List<BandSocialMedia> bandSocialMedias;

	public Band() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAboutUs() {
		return aboutUs;
	}

	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<BandMember> getBandMembers() {
		return bandMembers;
	}

	public void setBandMembers(List<BandMember> bandMembers) {
		this.bandMembers = bandMembers;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Profile getLeader() {
		return leader;
	}

	public void setLeader(Profile leader) {
		this.leader = leader;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTimeCommitment() {
		return timeCommitment;
	}

	public void setTimeCommitment(String timeCommitment) {
		this.timeCommitment = timeCommitment;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

//	public List<BandSocialMedia> getBandSocialMedias() {
//		return bandSocialMedias;
//	}
//
//	public void setBandSocialMedias(List<BandSocialMedia> bandSocialMedias) {
//		this.bandSocialMedias = bandSocialMedias;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Band other = (Band) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Band [id=" + id + ", name=" + name + ", aboutUs=" + aboutUs + ", genre=" + genre + ", email=" + email
				+ ", timeCommitment=" + timeCommitment + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	
}
