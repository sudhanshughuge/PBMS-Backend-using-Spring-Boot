package com.pbms.ProjectBackend.services;

import java.util.List;

import com.pbms.ProjectBackend.entities.User;

public interface UserService {
	
	public int getMaxUserId();
	
	public List<User> getUsers();

	public User getUser(int UserID);
	
	public User getUserByUsername(String Username);

	public User addUser(User user);

	public void updateUser(User user, int UserID);

	public void deleteUser(int UserID);
	
	
}
