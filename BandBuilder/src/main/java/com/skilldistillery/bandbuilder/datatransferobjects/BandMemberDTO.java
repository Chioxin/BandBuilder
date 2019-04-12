package com.skilldistillery.bandbuilder.datatransferobjects;

import java.util.Date;
import java.util.List;

import com.skilldistillery.bandbuilder.entities.Address;
import com.skilldistillery.bandbuilder.entities.Band;
import com.skilldistillery.bandbuilder.entities.BandMember;
import com.skilldistillery.bandbuilder.entities.BandSocialMedia;
import com.skilldistillery.bandbuilder.entities.Event;
import com.skilldistillery.bandbuilder.entities.Image;
import com.skilldistillery.bandbuilder.entities.Instrument;
import com.skilldistillery.bandbuilder.entities.Profile;
import com.skilldistillery.bandbuilder.entities.User;
import com.skilldistillery.bandbuilder.entities.UserInstrument;

public class BandMemberDTO {
	
	// Band Member
	private int bandMember_id;
	private Band bandMember_band;
	private Instrument bandMember_instrument;
	private Profile bandMember_profile;
	private String bandMember_description;
	private String bandMember_experience;
	private Date bandMember_joinedAt;
	private boolean bandMember_active;
	
	// Band
	private int band_id;
	private String band_name;
	private String band_aboutUs;
	private String band_genre;
	private List<BandMember> band_bandMembers;
	private Address band_address;
	private Profile band_leader;
	private String band_email;
	private String band_timeCommitment;
	private Date band_updatedAt;
	private List<BandSocialMedia> band_bandSocialMedias;
	private Image band_image;
	private List<Event> band_events;
	
	// Instrument
	private int instrument_id;
	private String instrument_name;
	private boolean instrument_approved;
	private Image instrument_image;
	private String instrument_description;
	private boolean instrument_active;

	// Profile
	private int profile_id;
	private User profile_user;
	private String profile_firstName;
	private String profile_lastName;
	private String profile_email;
	private String profile_aboutMe;
	private Address profile_address;
	private Image profile_image;
	private Date profile_createdAt;
	private Date profile_updatedAt;
	private List<Band> profile_bands;
	private List<BandMember> profile_bandMembers;
	private List<UserInstrument> profile_instruments;
	private boolean profile_active;
	
	// Getters and Setters
	public int getBandMember_id() {
		return bandMember_id;
	}
	public void setBandMember_id(int bandMember_id) {
		this.bandMember_id = bandMember_id;
	}
	public Band getBandMember_band() {
		return bandMember_band;
	}
	public void setBandMember_band(Band bandMember_band) {
		this.bandMember_band = bandMember_band;
	}
	public Instrument getBandMember_instrument() {
		return bandMember_instrument;
	}
	public void setBandMember_instrument(Instrument bandMember_instrument) {
		this.bandMember_instrument = bandMember_instrument;
	}
	public Profile getBandMember_profile() {
		return bandMember_profile;
	}
	public void setBandMember_profile(Profile bandMember_profile) {
		this.bandMember_profile = bandMember_profile;
	}
	public String getBandMember_description() {
		return bandMember_description;
	}
	public void setBandMember_description(String bandMember_description) {
		this.bandMember_description = bandMember_description;
	}
	public String getBandMember_experience() {
		return bandMember_experience;
	}
	public void setBandMember_experience(String bandMember_experience) {
		this.bandMember_experience = bandMember_experience;
	}
	public Date getBandMember_joinedAt() {
		return bandMember_joinedAt;
	}
	public void setBandMember_joinedAt(Date bandMember_joinedAt) {
		this.bandMember_joinedAt = bandMember_joinedAt;
	}
	public boolean isBandMember_active() {
		return bandMember_active;
	}
	public void setBandMember_active(boolean bandMember_active) {
		this.bandMember_active = bandMember_active;
	}
	public int getBand_id() {
		return band_id;
	}
	public void setBand_id(int band_id) {
		this.band_id = band_id;
	}
	public String getBand_name() {
		return band_name;
	}
	public void setBand_name(String band_name) {
		this.band_name = band_name;
	}
	public String getBand_aboutUs() {
		return band_aboutUs;
	}
	public void setBand_aboutUs(String band_aboutUs) {
		this.band_aboutUs = band_aboutUs;
	}
	public String getBand_genre() {
		return band_genre;
	}
	public void setBand_genre(String band_genre) {
		this.band_genre = band_genre;
	}
	public List<BandMember> getBand_bandMembers() {
		return band_bandMembers;
	}
	public void setBand_bandMembers(List<BandMember> band_bandMembers) {
		this.band_bandMembers = band_bandMembers;
	}
	public Address getBand_address() {
		return band_address;
	}
	public void setBand_address(Address band_address) {
		this.band_address = band_address;
	}
	public Profile getBand_leader() {
		return band_leader;
	}
	public void setBand_leader(Profile band_leader) {
		this.band_leader = band_leader;
	}
	public String getBand_email() {
		return band_email;
	}
	public void setBand_email(String band_email) {
		this.band_email = band_email;
	}
	public String getBand_timeCommitment() {
		return band_timeCommitment;
	}
	public void setBand_timeCommitment(String band_timeCommitment) {
		this.band_timeCommitment = band_timeCommitment;
	}
	public Date getBand_updatedAt() {
		return band_updatedAt;
	}
	public void setBand_updatedAt(Date band_updatedAt) {
		this.band_updatedAt = band_updatedAt;
	}
	public List<BandSocialMedia> getBand_bandSocialMedias() {
		return band_bandSocialMedias;
	}
	public void setBand_bandSocialMedias(List<BandSocialMedia> band_bandSocialMedias) {
		this.band_bandSocialMedias = band_bandSocialMedias;
	}
	public Image getBand_image() {
		return band_image;
	}
	public void setBand_image(Image band_image) {
		this.band_image = band_image;
	}
	public List<Event> getBand_events() {
		return band_events;
	}
	public void setBand_events(List<Event> band_events) {
		this.band_events = band_events;
	}
	public int getInstrument_id() {
		return instrument_id;
	}
	public void setInstrument_id(int instrument_id) {
		this.instrument_id = instrument_id;
	}
	public String getInstrument_name() {
		return instrument_name;
	}
	public void setInstrument_name(String instrument_name) {
		this.instrument_name = instrument_name;
	}
	public boolean isInstrument_approved() {
		return instrument_approved;
	}
	public void setInstrument_approved(boolean instrument_approved) {
		this.instrument_approved = instrument_approved;
	}
	public Image getInstrument_image() {
		return instrument_image;
	}
	public void setInstrument_image(Image instrument_image) {
		this.instrument_image = instrument_image;
	}
	public String getInstrument_description() {
		return instrument_description;
	}
	public void setInstrument_description(String instrument_description) {
		this.instrument_description = instrument_description;
	}
	public boolean isInstrument_active() {
		return instrument_active;
	}
	public void setInstrument_active(boolean instrument_active) {
		this.instrument_active = instrument_active;
	}
	public int getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}
	public User getProfile_user() {
		return profile_user;
	}
	public void setProfile_user(User profile_user) {
		this.profile_user = profile_user;
	}
	public String getProfile_firstName() {
		return profile_firstName;
	}
	public void setProfile_firstName(String profile_firstName) {
		this.profile_firstName = profile_firstName;
	}
	public String getProfile_lastName() {
		return profile_lastName;
	}
	public void setProfile_lastName(String profile_lastName) {
		this.profile_lastName = profile_lastName;
	}
	public String getProfile_email() {
		return profile_email;
	}
	public void setProfile_email(String profile_email) {
		this.profile_email = profile_email;
	}
	public String getProfile_aboutMe() {
		return profile_aboutMe;
	}
	public void setProfile_aboutMe(String profile_aboutMe) {
		this.profile_aboutMe = profile_aboutMe;
	}
	public Address getProfile_address() {
		return profile_address;
	}
	public void setProfile_address(Address profile_address) {
		this.profile_address = profile_address;
	}
	public Image getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(Image profile_image) {
		this.profile_image = profile_image;
	}
	public Date getProfile_createdAt() {
		return profile_createdAt;
	}
	public void setProfile_createdAt(Date profile_createdAt) {
		this.profile_createdAt = profile_createdAt;
	}
	public Date getProfile_updatedAt() {
		return profile_updatedAt;
	}
	public void setProfile_updatedAt(Date profile_updatedAt) {
		this.profile_updatedAt = profile_updatedAt;
	}
	public List<Band> getProfile_bands() {
		return profile_bands;
	}
	public void setProfile_bands(List<Band> profile_bands) {
		this.profile_bands = profile_bands;
	}
	public List<BandMember> getProfile_bandMembers() {
		return profile_bandMembers;
	}
	public void setProfile_bandMembers(List<BandMember> profile_bandMembers) {
		this.profile_bandMembers = profile_bandMembers;
	}
	public List<UserInstrument> getProfile_instruments() {
		return profile_instruments;
	}
	public void setProfile_instruments(List<UserInstrument> profile_instruments) {
		this.profile_instruments = profile_instruments;
	}
	public boolean isProfile_active() {
		return profile_active;
	}
	public void setProfile_active(boolean profile_active) {
		this.profile_active = profile_active;
	}
	
}
