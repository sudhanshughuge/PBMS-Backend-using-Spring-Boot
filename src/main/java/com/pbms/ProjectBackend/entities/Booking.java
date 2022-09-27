package com.pbms.ProjectBackend.entities;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Booking {
	
	@Id
	private int BookID;
	private String BookDate;
	private int CID;
	private String CName;
	private int PID;
	private String PName;
	private long Rate;
	private long BookingAmount;

	public Booking() {
    }

	public Booking(int bookID, String bookDate, int cID, String cName, int pID, String pName, long rate,
			long bookingAmount) {
		super();
		BookID = bookID;
		BookDate = bookDate;
		CID = cID;
		CName = cName;
		PID = pID;
		PName = pName;
		Rate = rate;
		BookingAmount = bookingAmount;
	}

	public int getBookID() {
		return BookID;
	}

	public void setBookID(int bookID) {
		BookID = bookID;
	}

	public String getBookDate() {
		return BookDate;
	}

	public void setBookDate(String bookDate) {
		BookDate = bookDate;
	}

	public int getCID() {
		return CID;
	}

	public void setCID(int cID) {
		CID = cID;
	}

	public String getCName() {
		return CName;
	}

	public void setCName(String cname) {
		CName = cname;
	}

	public int getPID() {
		return PID;
	}

	public void setPID(int pID) {
		PID = pID;
	}

	public String getPName() {
		return PName;
	}

	public void setPName(String pName) {
		PName = pName;
	}

	public long getRate() {
		return Rate;
	}

	public void setRate(long rate) {
		Rate = rate;
	}

	public long getBookingAmount() {
		return BookingAmount;
	}

	public void setBookingAmount(long bookingAmount) {
		BookingAmount = bookingAmount;
	}

	@Override
	public String toString() {
		return "Booking [BookID=" + BookID + ", BookDate=" + BookDate + ", CID=" + CID + ", CName=" + CName + ", PID="
				+ PID + ", PName=" + PName + ", Rate=" + Rate + ", BookingAmount=" + BookingAmount + "]";
	}

	
}
