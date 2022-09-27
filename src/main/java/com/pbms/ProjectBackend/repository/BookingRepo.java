package com.pbms.ProjectBackend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.pbms.ProjectBackend.entities.Booking;

public interface BookingRepo extends CrudRepository<Booking, Integer> {

	@Query(value = "SELECT max(BookID) FROM Booking")
	String getMaxBookingId();
}
