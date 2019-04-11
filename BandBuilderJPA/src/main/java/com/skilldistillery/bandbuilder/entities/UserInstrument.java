package com.skilldistillery.bandbuilder.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class UserInstrument {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name="profile_id")
	private Profile profile;

	@OneToMany
	@JoinColumn(name="instrument_id")
	private Instrument instrument;

	private String experience;

	private String description;

	public UserInstrument() {
		super();
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
		UserInstrument other = (UserInstrument) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserInstrument [id=" + id + ", profile=" + profile + ", instrument=" + instrument + ", experience="
				+ experience + ", description=" + description + "]";
	}

}
