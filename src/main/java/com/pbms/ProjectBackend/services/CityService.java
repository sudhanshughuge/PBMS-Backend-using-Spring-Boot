package com.pbms.ProjectBackend.services;

import java.util.List;

import com.pbms.ProjectBackend.entities.City;

public interface CityService {

	public List<City> getCities();
	
	public List<City> addCities(List<City> cities);

	public City getCity(int CityId);
}
