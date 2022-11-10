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
import com.pbms.ProjectBackend.entities.Property;
import com.pbms.ProjectBackend.services.BookingService;
import com.pbms.ProjectBackend.services.PropertyService;

@RestController
@RequestMapping("/bookings")
@CrossOrigin("*")
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@Autowired
	PropertyService propertyService;
	
	@GetMapping("/")
	public List<Booking> getBookings()
	{
		return bookingService.getBookings();
	}
	
	@GetMapping("/{BookID}")
	public Booking getBooking(@PathVariable int BookID)
	{
		return bookingService.getBooking(BookID);
	}
	
	@GetMapping("/maxid")
	public int getMaxBookingId() 
	{
		return bookingService.getMaxBookingId();
	}
	
	@PostMapping("/")
	public Booking addBooking(@RequestBody Booking booking)
	{
		long millis=System.currentTimeMillis();
		booking.setBookID(getMaxBookingId()+1);
		booking.setBookDate(new java.sql.Date(millis).toString());
		// this is done to update Booking Status in Property Table
		int PropID = booking.getPID();
		Property property = propertyService.getProperty(PropID);
		property.setBookStatus("Booked");
		propertyService.updateProperty(property, PropID);
		
		return bookingService.addBooking(booking);
	}
	
	@PutMapping("/{BookID}")
	public void updateBooking(@RequestBody Booking booking, @PathVariable int BookID)
	{
		bookingService.updateBooking(booking, BookID);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{BookID}")
	public void deleteBooking(@PathVariable int BookID)
	{
		Property property = propertyService.getProperty(bookingService.getBooking(BookID).getPID());
		property.setBookStatus("Available");
		bookingService.deleteBooking(BookID);
	}
}
