package com.skilldistillery.bandbuilder.datatransferobjects;

import java.util.Date;
import java.util.List;

import com.skilldistillery.bandbuilder.entities.Band;
import com.skilldistillery.bandbuilder.entities.Image;
import com.skilldistillery.bandbuilder.entities.Instrument;
import com.skilldistillery.bandbuilder.entities.Profile;
import com.skilldistillery.bandbuilder.entities.SocialMedia;

public class BandDTO {

	// Band
	private int band_id;
	private String band_name;
	private String band_aboutUs;
	private String band_genre;
	private String band_bandEmail;
	private String band_timeCommitment;
	private Image band_image;
	
	// Address
	private int address_id;
	private String address_street;
	private String address_street2;
	private String address_city;
	private String address_state;
	private String address_zip;
	private String address_phone;
	
	// Band Members
	private int bandMember_id;
	private Band bandMember_band;
	private Instrument bandMember_instrument;
	private Profile bandMember_profile;
	private String bandMember_description;
	private String bandMember_experience;
	public void setBandSocialMedia_socialMedia(SocialMedia bandSocialMedia_socialMedia) {
		this.bandSocialMedia_socialMedia = bandSocialMedia_socialMedia;
	}
	private Date bandMember_joinedAt;
	
	// Band Social Media
	private int bandSocialMedia_id;
	private SocialMedia bandSocialMedia_socialMedia;
	private Band bandSocialMedia_band;
	private String bandSocialMedia_url;

	// Getters and Setters
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
	public String getBand_bandEmail() {
		return band_bandEmail;
	}
	public void setBand_bandEmail(String band_bandEmail) {
		this.band_bandEmail = band_bandEmail;
	}
	public String getBand_timeCommitment() {
		return band_timeCommitment;
	}
	public void setBand_timeCommitment(String band_timeCommitment) {
		this.band_timeCommitment = band_timeCommitment;
	}
	public Image getBand_image() {
		return band_image;
	}
	public void setBand_image(Image band_image) {
		this.band_image = band_image;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getAddress_street() {
		return address_street;
	}
	public void setAddress_street(String address_street) {
		this.address_street = address_street;
	}
	public String getAddress_street2() {
		return address_street2;
	}
	public void setAddress_street2(String address_street2) {
		this.address_street2 = address_street2;
	}
	public String getAddress_city() {
		return address_city;
	}
	public void setAddress_city(String address_city) {
		this.address_city = address_city;
	}
	public String getAddress_state() {
		return address_state;
	}
	public void setAddress_state(String address_state) {
		this.address_state = address_state;
	}
	public String getAddress_zip() {
		return address_zip;
	}
	public void setAddress_zip(String address_zip) {
		this.address_zip = address_zip;
	}
	public String getAddress_phone() {
		return address_phone;
	}
	public void setAddress_phone(String address_phone) {
		this.address_phone = address_phone;
	}
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
	public int getBandSocialMedia_id() {
		return bandSocialMedia_id;
	}
	public void setBandSocialMedia_id(int bandSocialMedia_id) {
		this.bandSocialMedia_id = bandSocialMedia_id;
	}
	public List<SocialMedia> getBandSocialMedia_socialMedia() {
		return bandSocialMedia_socialMedia;
	}
	public void setBandSocialMedia_socialMedia(List<SocialMedia> bandSocialMedia_socialMedia) {
		this.bandSocialMedia_socialMedia = bandSocialMedia_socialMedia;
	}
	public Band getBandSocialMedia_band() {
		return bandSocialMedia_band;
	}
	public void setBandSocialMedia_band(Band bandSocialMedia_band) {
		this.bandSocialMedia_band = bandSocialMedia_band;
	}
	public String getBandSocialMedia_url() {
		return bandSocialMedia_url;
	}
	public void setBandSocialMedia_url(String bandSocialMedia_url) {
		this.bandSocialMedia_url = bandSocialMedia_url;
	}
	
}
