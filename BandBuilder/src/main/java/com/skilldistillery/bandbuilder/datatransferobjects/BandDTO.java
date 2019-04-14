package com.skilldistillery.bandbuilder.datatransferobjects;

import java.util.Date;

import com.skilldistillery.bandbuilder.entities.Band;
import com.skilldistillery.bandbuilder.entities.Image;
import com.skilldistillery.bandbuilder.entities.Instrument;
import com.skilldistillery.bandbuilder.entities.Profile;
import com.skilldistillery.bandbuilder.entities.SocialMedia;

public class BandDTO {

	// Band
	private int bandId;
	private String bandName;
	private String bandAboutUs;
	private String bandGenre;
	private String bandBandEmail;
	private String bandTimeCommitment;
	private Image bandImage;
	
	// Address
	private int addressId;
	private String addressStreet;
	private String addressStreet2;
	private String addressCity;
	private String addressState;
	private String addressZip;
	private String addressPhone;
	
	// Band Members
	private int bandMemberId;
	private Band bandMemberBand;
	private Instrument bandMemberInstrument;
	private Profile bandMemberProfile;
	private String bandMemberDescription;
	private String bandMemberExperience;
	private Date bandMemberJoinedAt;
	
	// Band Social Media
	private int bandSocialMediaId;
	private SocialMedia bandSocialMediaSocialMedia;
	private Band bandSocialMediaBand;
	private String bandSocialMediaUrl;
	
	// Profile
	private int bandLeader;

	// Getter and Setters
	public int getBandId() {
		return bandId;
	}

	public void setBandId(int bandId) {
		this.bandId = bandId;
	}

	public String getBandName() {
		return bandName;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

	public String getBandAboutUs() {
		return bandAboutUs;
	}

	public void setBandAboutUs(String bandAboutUs) {
		this.bandAboutUs = bandAboutUs;
	}

	public String getBandGenre() {
		return bandGenre;
	}

	public void setBandGenre(String bandGenre) {
		this.bandGenre = bandGenre;
	}

	public String getBandBandEmail() {
		return bandBandEmail;
	}

	public void setBandBandEmail(String bandBandEmail) {
		this.bandBandEmail = bandBandEmail;
	}

	public String getBandTimeCommitment() {
		return bandTimeCommitment;
	}

	public void setBandTimeCommitment(String bandTimeCommitment) {
		this.bandTimeCommitment = bandTimeCommitment;
	}

	public Image getBandImage() {
		return bandImage;
	}

	public void setBandImage(Image bandImage) {
		this.bandImage = bandImage;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressStreet2() {
		return addressStreet2;
	}

	public void setAddressStreet2(String addressStreet2) {
		this.addressStreet2 = addressStreet2;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressZip() {
		return addressZip;
	}

	public void setAddressZip(String addressZip) {
		this.addressZip = addressZip;
	}

	public String getAddressPhone() {
		return addressPhone;
	}

	public void setAddressPhone(String addressPhone) {
		this.addressPhone = addressPhone;
	}

	public int getBandMemberId() {
		return bandMemberId;
	}

	public void setBandMemberId(int bandMemberId) {
		this.bandMemberId = bandMemberId;
	}

	public Band getBandMemberBand() {
		return bandMemberBand;
	}

	public void setBandMemberBand(Band bandMemberBand) {
		this.bandMemberBand = bandMemberBand;
	}

	public Instrument getBandMemberInstrument() {
		return bandMemberInstrument;
	}

	public void setBandMemberInstrument(Instrument bandMemberInstrument) {
		this.bandMemberInstrument = bandMemberInstrument;
	}

	public Profile getBandMemberProfile() {
		return bandMemberProfile;
	}

	public void setBandMemberProfile(Profile bandMemberProfile) {
		this.bandMemberProfile = bandMemberProfile;
	}

	public String getBandMemberDescription() {
		return bandMemberDescription;
	}

	public void setBandMemberDescription(String bandMemberDescription) {
		this.bandMemberDescription = bandMemberDescription;
	}

	public String getBandMemberExperience() {
		return bandMemberExperience;
	}

	public void setBandMemberExperience(String bandMemberExperience) {
		this.bandMemberExperience = bandMemberExperience;
	}

	public Date getBandMemberJoinedAt() {
		return bandMemberJoinedAt;
	}

	public void setBandMemberJoinedAt(Date bandMemberJoinedAt) {
		this.bandMemberJoinedAt = bandMemberJoinedAt;
	}

	public int getBandSocialMediaId() {
		return bandSocialMediaId;
	}

	public void setBandSocialMediaId(int bandSocialMediaId) {
		this.bandSocialMediaId = bandSocialMediaId;
	}

	public SocialMedia getBandSocialMediaSocialMedia() {
		return bandSocialMediaSocialMedia;
	}

	public void setBandSocialMediaSocialMedia(SocialMedia bandSocialMediaSocialMedia) {
		this.bandSocialMediaSocialMedia = bandSocialMediaSocialMedia;
	}

	public Band getBandSocialMediaBand() {
		return bandSocialMediaBand;
	}

	public void setBandSocialMediaBand(Band bandSocialMediaBand) {
		this.bandSocialMediaBand = bandSocialMediaBand;
	}

	public String getBandSocialMediaUrl() {
		return bandSocialMediaUrl;
	}

	public void setBandSocialMediaUrl(String bandSocialMediaUrl) {
		this.bandSocialMediaUrl = bandSocialMediaUrl;
	}

	public int getBandLeader() {
		return bandLeader;
	}

	public void setBandLeader(int bandLeader) {
		this.bandLeader = bandLeader;
	}
	
	
	
	
}
