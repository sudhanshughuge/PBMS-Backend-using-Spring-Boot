package com.pbms.ProjectBackend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payment {

	@Id
	private int PayID;
	private int BookID;
    private String CName;
    private long Rate;
    private long AmountPaid;
    private long AmountRem;
    private String PayDate;
    
	public Payment() {
		super();
	}

	public Payment(int payID, int bookID, String cName, long rate, long amountPaid, long amountRem, String payDate) {
		super();
		PayID = payID;
		BookID = bookID;
		CName = cName;
		Rate = rate;
		AmountPaid = amountPaid;
		AmountRem = amountRem;
		PayDate = payDate;
	}

	public int getPayID() {
		return PayID;
	}

	public void setPayID(int payID) {
		PayID = payID;
	}

	public int getBookID() {
		return BookID;
	}

	public void setBookID(int bookID) {
		BookID = bookID;
	}

	public String getCName() {
		return CName;
	}

	public void setCName(String cName) {
		CName = cName;
	}

	public long getRate() {
		return Rate;
	}

	public void setRate(long rate) {
		Rate = rate;
	}

	public long getAmountPaid() {
		return AmountPaid;
	}

	public void setAmountPaid(long amountPaid) {
		AmountPaid = amountPaid;
	}

	public long getAmountRem() {
		return AmountRem;
	}

	public void setAmountRem(long amountRem) {
		AmountRem = amountRem;
	}

	public String getPayDate() {
		return PayDate;
	}

	public void setPayDate(String payDate) {
		PayDate = payDate;
	}

	@Override
	public String toString() {
		return "Payment [PayID=" + PayID + ", BookID=" + BookID + ", CName=" + CName + ", Rate=" + Rate
				+ ", AmountPaid=" + AmountPaid + ", AmountRem=" + AmountRem + ", PayDate=" + PayDate + "]";
	}
	
    
    
}
