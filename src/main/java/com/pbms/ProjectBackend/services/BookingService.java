package com.pbms.ProjectBackend.services;

import java.util.List;

import com.pbms.ProjectBackend.entities.Booking;

public interface BookingService {
	
	public List<Booking> getBookings();

	public Booking getBooking(int BookID);

	public Booking addBooking(Booking booking);

	public void updateBooking(Booking booking, int BookID);

	public void deleteBooking(int BookID);

	public int getMaxBookingId();
	
	
}
