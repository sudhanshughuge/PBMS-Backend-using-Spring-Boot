package com.pbms.ProjectBackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbms.ProjectBackend.entities.User;

import com.pbms.ProjectBackend.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	public UserServiceImpl(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public List<User> getUsers() {
		List<User> users = (List<User>) userRepo.findAll();
		return users;
	}

	@Override
	public User getUser(int UserID) {
		User user = this.userRepo.findById(UserID).orElseThrow();
		return user;
	}

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public void updateUser(User user, int UserID) {
		user.setUserID(UserID);
		userRepo.save(user);
	}

	@Override
	public void deleteUser(int UserID) {
		userRepo.deleteById(UserID);		
	}

	@Override
	public User getUserByUsername(String username) {
		User user = userRepo.findByUsername(username);
		return user;
	}

	@Override
	public int getMaxUserId() {
		if ((userRepo.getMaxUserId())== null) {
			return 0;
		}
		else {
			return Integer.parseInt(userRepo.getMaxUserId());
		}
	}
}