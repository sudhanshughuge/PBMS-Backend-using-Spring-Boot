package com.pbms.ProjectBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbms.ProjectBackend.entities.User;
import com.pbms.ProjectBackend.services.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/")
	public List<User> getUsers()
	{
		return userService.getUsers();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{UserID}")
	public User getUser(@PathVariable int UserID)
	{
		return userService.getUser(UserID);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/")
	public User addUser(@RequestBody User user)
	{
		user.setUserID(userService.getMaxUserId()+1);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userService.addUser(user);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{UserID}")
	public void updateUser(@RequestBody User user, @PathVariable int UserID)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.updateUser(user, UserID);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{UserID}")
	public void deleteUser(@PathVariable int UserID)
	{
		userService.deleteUser(UserID);
	}
}
