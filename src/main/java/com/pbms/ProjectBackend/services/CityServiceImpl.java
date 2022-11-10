package com.pbms.ProjectBackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbms.ProjectBackend.entities.City;
import com.pbms.ProjectBackend.repository.CityRepo;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	private CityRepo cityRepo;
	
	@Override
	public List<City> getCities() {
		List<City> cities = (List<City>) cityRepo.findAll();
		return cities;
	}

	@Override
	public City getCity(int CityId) {
		return cityRepo.findById(CityId).orElseThrow();
	}

	@Override
	public List<City> addCities(List<City> cities) {
		List<City> citylist = (List<City>) cityRepo.saveAll(cities);
		return citylist;
	}

}
