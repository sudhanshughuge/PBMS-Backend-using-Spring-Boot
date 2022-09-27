package com.pbms.ProjectBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbms.ProjectBackend.entities.Booking;
import com.pbms.ProjectBackend.entities.Payment;
import com.pbms.ProjectBackend.services.BookingService;
import com.pbms.ProjectBackend.services.PaymentService;

@RestController
@RequestMapping("/payments")
@CrossOrigin("*")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping("/")
	public List<Payment> getPayments()
	{
		return paymentService.getPayments();
	}
	
	@GetMapping("/maxid")
	public int getMaxPaymentId() 
	{
		return paymentService.getMaxPaymentId();
	}
	
	@GetMapping("/{PayID}")
	public Payment getPayment(@PathVariable int PayID)
	{
		return paymentService.getPayment(PayID);
	}
	
	@GetMapping("/getamountpaid/{BookID}")
	public long getAmountPaid(@PathVariable int BookID) {
		if (paymentService.isBookIdInPayment(BookID)) {
			return paymentService.getAmountPaid(BookID);
		} else {
			Booking booking = bookingService.getBooking(BookID);
			return booking.getBookingAmount();
		}
	}
	
	@PostMapping("/")
	public Payment addPayment(@RequestBody Payment payment)
	{
		payment.setPayID(getMaxPaymentId()+1);
		long millis=System.currentTimeMillis();
		payment.setPayDate(new java.sql.Date(millis).toString());
		return paymentService.addPayment(payment);
	}
	
	@PutMapping("/{PayID}")
	public void updatePayment(@RequestBody Payment payment, @PathVariable int PayID)
	{
		paymentService.updatePayment(payment, PayID);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{PayID}")
	public void deletePayment(@PathVariable int PayID)
	{
		paymentService.deletePayment(PayID);
	}
}
