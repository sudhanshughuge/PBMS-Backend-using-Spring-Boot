package com.pbms.ProjectBackend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class City {

	@Id
	private int CityID;
	private String City;
	private String state;
	
}
