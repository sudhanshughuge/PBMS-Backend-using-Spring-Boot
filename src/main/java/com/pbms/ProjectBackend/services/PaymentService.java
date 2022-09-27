package com.pbms.ProjectBackend.services;

import java.util.List;

import com.pbms.ProjectBackend.entities.Payment;

public interface PaymentService {
	
	public int getMaxPaymentId();
	
	public boolean isBookIdInPayment(int bookid);
	
	public List<Payment> getPayments();

	public Payment getPayment(int PayID);

	public Payment addPayment(Payment payment);

	public void updatePayment(Payment payment, int PayID);

	public void deletePayment(int PayID);
	
	public long getAmountPaid (int bookid);
	
}
