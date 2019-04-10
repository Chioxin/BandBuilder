package com.skilldistillery.bandbuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BandSocialMedia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="social_media")
	private SocialMedia socialMedia;
	
	private Band band;

	public BandSocialMedia() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SocialMedia getSocialMedia() {
		return socialMedia;
	}

	public void setSocialMedia(SocialMedia socialMedia) {
		this.socialMedia = socialMedia;
	}

	public Band getBand() {
		return band;
	}

	public void setBand(Band band) {
		this.band = band;
	}

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
		BandSocialMedia other = (BandSocialMedia) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BandSocialMedia [id=" + id + "]";
	}
	
	

}
