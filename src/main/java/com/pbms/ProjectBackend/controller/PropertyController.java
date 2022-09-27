package com.pbms.ProjectBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbms.ProjectBackend.entities.Property;
import com.pbms.ProjectBackend.services.PropertyService;

@RestController
@RequestMapping("/property")
@CrossOrigin("*")
public class PropertyController {

	@Autowired
	PropertyService propertyService;
	
	@GetMapping("/")
	public List<Property> getProperties()
	{
		return propertyService.getProperties();
	}
	
	@GetMapping("/available")
	public List<Property> getAvailableProperties()
	{
		return propertyService.getAvailableProperties();
	}
	
	@GetMapping("/maxid")
	public int getMaxPropertyId() 
	{
		return propertyService.getMaxPropertyId();
	}
	
	@GetMapping("/{PropID}")
	public Property getProperty(@PathVariable int PropID)
	{
		return propertyService.getProperty(PropID);
	}
	
	@PostMapping("/")
	public Property addProperty(@RequestBody Property property)
	{
		property.setPropID(propertyService.getMaxPropertyId()+1) ;
		property.setBookStatus("Available");
		return propertyService.addProperty(property);
	}
	
	@PutMapping("/{PropID}")
	public void updateProperty(@RequestBody Property property, @PathVariable int PropID)
	{
		propertyService.updateProperty(property, PropID);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{PropID}")
	public void deleteProperty(@PathVariable int PropID)
	{
		propertyService.deleteProperty(PropID);
	}
}
