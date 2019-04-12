package com.skilldistillery.bandbuilder.datatransferobjects;

public class ProfileDTO {
	
	// User Entity
	private int userId;
	private int userPassword;
	private boolean userActive;
	private String role;
	
	// Profile Entity
	private int profileId;
	private String profileFirstName;
	private String profileLastName;
	private String profileEmail;
	private String profileAboutMe;
	
	// Address Entity
	private String addressStreet;
	private String addressStreet2;
	private String addressCity;
	private String addressState;
	private String addressPhone;
	
	// Getters and Setters
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(int userPassword) {
		this.userPassword = userPassword;
	}
	public boolean isUserActive() {
		return userActive;
	}
	public void setUserActive(boolean userActive) {
		this.userActive = userActive;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getProfileFirstName() {
		return profileFirstName;
	}
	public void setProfileFirstName(String profileFirstName) {
		this.profileFirstName = profileFirstName;
	}
	public String getProfileLastName() {
		return profileLastName;
	}
	public void setProfileLastName(String profileLastName) {
		this.profileLastName = profileLastName;
	}
	public String getProfileEmail() {
		return profileEmail;
	}
	public void setProfileEmail(String profileEmail) {
		this.profileEmail = profileEmail;
	}
	public String getProfileAboutMe() {
		return profileAboutMe;
	}
	public void setProfileAboutMe(String profileAboutMe) {
		this.profileAboutMe = profileAboutMe;
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
	public String getAddressPhone() {
		return addressPhone;
	}
	public void setAddressPhone(String addressPhone) {
		this.addressPhone = addressPhone;
	}

}
