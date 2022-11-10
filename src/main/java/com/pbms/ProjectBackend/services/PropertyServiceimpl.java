package com.pbms.ProjectBackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pbms.ProjectBackend.entities.Property;
import com.pbms.ProjectBackend.repository.PropertyRepo;

@Service
public class PropertyServiceimpl implements PropertyService {

	@Autowired
	private PropertyRepo propertyRepo;

	@Override
	public List<Property> getProperties() {
		List<Property> properties =  (List<Property>) propertyRepo.findAll();
		return properties;
	}
	
	@Override
	public List<Property> getAvailableProperties() {
		List<Property> properties = (List<Property>) propertyRepo.getAvailableProperties();	
		return properties;
	}

	@Override
	public Property getProperty(int PropID) {
		Property property= this.propertyRepo.findById(PropID).orElseThrow();
		return property;
	}

	@Override
	public Property addProperty(Property property) {
		property.setBookStatus("Available");
		Property prop=propertyRepo.save(property);
		return prop;
	}

	@Override
	public void updateProperty(Property property, int PropID) {
		property.setPropID(PropID);
		propertyRepo.save(property);
	}

	@Override
	public void deleteProperty(int PropID) {
		propertyRepo.deleteById(PropID);
	}

	@Override
	public int getMaxPropertyId() {
		
		if ((propertyRepo.getMaxPropertyId())== null) {
			return 0;
		}
		else {
			return Integer.parseInt(propertyRepo.getMaxPropertyId());
		}
		
	}
}
