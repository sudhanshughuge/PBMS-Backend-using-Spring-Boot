package com.pbms.ProjectBackend.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
public class User implements UserDetails{
	@Id
	private int UserID;
	private String Name;

	@Column(unique = true, nullable = false)
	private String username;
	private String Password;

	@Column(unique = true, nullable = false)
	private String Email;
	private String role;

	@JsonIgnore
	public String getPassword() {
		return this.Password;
	}
	
	@JsonProperty
	public void setPassword(String password) {
		this.Password=password;
	}

	public User(int userID, String name, String username, String password, String email, String role) {
		super();
		UserID = userID;
		Name = name;
		this.username = username;
		Password = password;
		Email = email;
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		HashSet<SimpleGrantedAuthority> authorities=new HashSet<>();
		authorities.add(new SimpleGrantedAuthority(this.getRole()));
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


}