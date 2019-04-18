package com.skilldistillery.bandbuilder.datatransferobjects;

public class InstrumentDTO {

	// Instrument Entity
	private int instrumentId;
	private String instrumentName;
	private boolean instrumentApproved;
	private String instrumentDescription;
	private String instrumentActive;

	// Image Entity
	private int imageId;
	private String imageURL;
	private String imageAlt;
	private String imageDescription;

	// Getters and Setters
	public int getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(int instrumentId) {
		this.instrumentId = instrumentId;
	}

	public String getInstrumentName() {
		return instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	public boolean isInstrumentApproved() {
		return instrumentApproved;
	}

	public void setInstrumentApproved(boolean instrumentApproved) {
		this.instrumentApproved = instrumentApproved;
	}

	public String getInstrumentDescription() {
		return instrumentDescription;
	}

	public void setInstrumentDescription(String instrumentDescription) {
		this.instrumentDescription = instrumentDescription;
	}

	public String getInstrumentActive() {
		return instrumentActive;
	}

	public void setInstrumentActive(String instrumentActive) {
		this.instrumentActive = instrumentActive;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getImageAlt() {
		return imageAlt;
	}

	public void setImageAlt(String imageAlt) {
		this.imageAlt = imageAlt;
	}

	public String getImageDescription() {
		return imageDescription;
	}

	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}

}
