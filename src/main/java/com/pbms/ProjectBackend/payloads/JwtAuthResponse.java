package com.pbms.ProjectBackend.payloads;

import com.pbms.ProjectBackend.entities.User;

import lombok.Data;
@Data
public class JwtAuthResponse {

	private String token;
	
	private User user;
	
	public JwtAuthResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public JwtAuthResponse() {
		super();
	}

	
	
}
