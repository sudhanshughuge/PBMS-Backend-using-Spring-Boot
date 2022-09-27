package com.pbms.ProjectBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbms.ProjectBackend.entities.City;
import com.pbms.ProjectBackend.services.CityService;

@RestController
@RequestMapping("/cities")
@CrossOrigin("*")
public class CityController {

	@Autowired
	CityService cityService;
	
	@GetMapping("/")
	public List<City> getCities()
	{
		return cityService.getCities();
	}
	
	
	
	@GetMapping("/{CityId}")
	public City getCustomer(@PathVariable int CityId)
	{
		return cityService.getCity(CityId);
	}
	
	@PostMapping("/")
	public List<City> addCities(@RequestBody List<City> cities)
	{
		return cityService.addCities(cities);
	}
}
