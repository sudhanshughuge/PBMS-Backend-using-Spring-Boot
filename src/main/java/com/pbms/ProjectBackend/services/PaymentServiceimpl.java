package com.pbms.ProjectBackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbms.ProjectBackend.entities.Payment;
import com.pbms.ProjectBackend.repository.PaymentRepo;

@Service
public class PaymentServiceimpl implements PaymentService {

	@Autowired
	private PaymentRepo paymentRepo;

	@Override
	public List<Payment> getPayments() {
		List<Payment> payments = (List<Payment>) paymentRepo.findAll();
		return payments;
	}

	@Override
	public Payment getPayment(int PayID) {
		Payment payment = this.paymentRepo.findById(PayID).orElseThrow();
		return payment;
	}

	@Override
	public Payment addPayment(Payment payment) {
		return paymentRepo.save(payment);
	}

	@Override
	public void updatePayment(Payment payment, int PayID) {
		payment.setPayID(PayID);
		paymentRepo.save(payment);
	}

	@Override
	public void deletePayment(int PayID) {
		paymentRepo.deleteById(PayID);
	}

	@Override
	public int getMaxPaymentId() {

		if ((paymentRepo.getMaxPaymentId()) == null) {
			return 0;
		} else {
			return Integer.parseInt(paymentRepo.getMaxPaymentId());
		}

	}

	@Override
	public boolean isBookIdInPayment(int bookid) {

		if ((paymentRepo.checkBookIdInPayment(bookid)) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public long getAmountPaid(int bookid) {
		return paymentRepo.getAmountPaid(bookid);
	}

}
