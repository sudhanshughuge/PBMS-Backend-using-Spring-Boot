package com.pbms.ProjectBackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbms.ProjectBackend.entities.Booking;
import com.pbms.ProjectBackend.exceptions.ResourceNotFoundException;
import com.pbms.ProjectBackend.repository.BookingRepo;

@Service
public class BookingServiceimpl implements BookingService {

	@Autowired
	private BookingRepo bookingRepo;

	@Override
	public List<Booking> getBookings() {
		List<Booking> bookings =  (List<Booking>) bookingRepo.findAll();
		return bookings;
	}

	@Override
	public Booking getBooking(int BookID) {
		Booking booking = this.bookingRepo.findById(BookID).orElseThrow(()-> new ResourceNotFoundException("Booking", "id", BookID));
		return booking;
	}

	@Override
	public Booking addBooking(Booking booking) {
		return bookingRepo.save(booking);
	}

	@Override
	public void updateBooking(Booking booking, int BookID) {
		booking.setBookID(BookID);
		bookingRepo.save(booking);
	}

	@Override
	public void deleteBooking(int BookID) {
		bookingRepo.deleteById(BookID);
	}

	@Override
	public int getMaxBookingId() {
		if ((bookingRepo.getMaxBookingId())== null) {
			return 0;
		}
		else {
			return Integer.parseInt(bookingRepo.getMaxBookingId());
		}
		
	}
	
	

	

}
