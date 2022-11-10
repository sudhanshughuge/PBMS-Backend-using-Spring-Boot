package com.pbms.ProjectBackend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pbms.ProjectBackend.entities.Property;

public interface PropertyRepo extends CrudRepository<Property, Integer>{

	@Query(value = "SELECT max(PropID) FROM Property")
	String getMaxPropertyId();
	
	@Query(value = "SELECT * FROM property where book_status='Available'", nativeQuery = true)
	Iterable<Property> getAvailableProperties();
}
