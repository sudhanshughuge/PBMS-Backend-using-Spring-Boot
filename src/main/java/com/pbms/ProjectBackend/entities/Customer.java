package com.pbms.ProjectBackend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	private int CustID;
    private String CustName;
    private String CustMobNo;
    private String email;
    private String CustAddress;
    private String CustCity;
    private String state;
    private String pincode;
    
	public Customer(int custID, String custName, String custMobNo, String email, String custAddress, String custCity,
			String state, String pincode) {
		super();
		CustID = custID;
		CustName = custName;
		CustMobNo = custMobNo;
		this.email = email;
		CustAddress = custAddress;
		CustCity = custCity;
		this.state = state;
		this.pincode = pincode;
	}
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCustID() {
		return CustID;
	}
	public void setCustID(int custID) {
		CustID = custID;
	}
	public String getCustName() {
		return CustName;
	}
	public void setCustName(String custName) {
		CustName = custName;
	}
	public String getCustMobNo() {
		return CustMobNo;
	}
	public void setCustMobNo(String custMobNo) {
		CustMobNo = custMobNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCustAddress() {
		return CustAddress;
	}
	public void setCustAddress(String custAddress) {
		CustAddress = custAddress;
	}
	public String getCustCity() {
		return CustCity;
	}
	public void setCustCity(String custCity) {
		CustCity = custCity;
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
	
	@Override
	public String toString() {
		return "Customer [CustID=" + CustID + ", CustName=" + CustName + ", CustMobNo=" + CustMobNo + ", email=" + email
				+ ", CustAddress=" + CustAddress + ", CustCity=" + CustCity + ", state=" + state + ", pincode="
				+ pincode + "]";
	}
    
    
}
