package com.pbms.ProjectBackend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pbms.ProjectBackend.entities.User;

public interface UserRepo extends CrudRepository<User, Integer> {

	User findByUsername(String Username);
	
	@Query(value = "SELECT max(UserID) FROM User")
	String getMaxUserId();
}
