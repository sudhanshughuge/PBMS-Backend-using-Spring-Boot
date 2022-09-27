package com.pbms.ProjectBackend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Property {

	@Id
	private int PropID;
	private String PropName;
	private String PropAddress;
	private String PropCity;
	private String state;
	private String pincode;
	private long rate;
	private String BookStatus;

	public Property(int propID, String propName, String propAddress, String propCity, String state, String pincode,
			long rate, String bookStatus) {
		super();
		PropID = propID;
		PropName = propName;
		PropAddress = propAddress;
		PropCity = propCity;
		this.state = state;
		this.pincode = pincode;
		this.rate = rate;
		this.BookStatus = bookStatus;
	}

	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getBookStatus() {
		return BookStatus;
	}

	public void setBookStatus(String bookStatus) {
		BookStatus = bookStatus;
	}


	public int getPropID() {
		return PropID;
	}

	public void setPropID(int propID) {
		PropID = propID;
	}

	public String getPropName() {
		return PropName;
	}

	public void setPropName(String propName) {
		PropName = propName;
	}

	public String getPropAddress() {
		return PropAddress;
	}

	public void setPropAddress(String propAddress) {
		PropAddress = propAddress;
	}

	public String getPropCity() {
		return PropCity;
	}

	public void setPropCity(String propCity) {
		PropCity = propCity;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public long getRate() {
		return rate;
	}

	public void setRate(long rate) {
		this.rate = rate;
	}

}
