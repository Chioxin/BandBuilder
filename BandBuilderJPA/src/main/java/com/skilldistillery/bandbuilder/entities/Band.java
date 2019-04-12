package com.skilldistillery.bandbuilder.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "band")
public class Band {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@Column(name = "about_us")
	private String aboutUs;

	private String genre;

	@JsonIgnore
	@OneToMany(mappedBy = "band")
	private List<BandMember> bandMembers;

	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@ManyToOne
	@JoinColumn(name = "leader_id")
	private Profile leader;

	private String email;

	@Column(name = "time_commitment")
	private String timeCommitment;

	@Column(name = "created_at")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name = "updated_at")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@JsonIgnore
	@OneToMany(mappedBy = "band")
	private List<BandSocialMedia> bandSocialMedias;

//	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "image_id")
	private Image image;

	@JsonIgnore
	@OneToMany(mappedBy = "band")
	private List<Event> events;

	private boolean active;

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

	public List<BandSocialMedia> getBandSocialMedias() {
		return bandSocialMedias;
	}

	public void setBandSocialMedias(List<BandSocialMedia> bandSocialMedias) {
		this.bandSocialMedias = bandSocialMedias;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
		Band other = (Band) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Band [id=" + id + ", name=" + name + ", aboutUs=" + aboutUs + ", genre=" + genre + ", address="
				+ address + ", leader=" + leader + ", email=" + email + ", timeCommitment=" + timeCommitment
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", image=" + image + ", active=" + active
				+ "]";
	}

}
