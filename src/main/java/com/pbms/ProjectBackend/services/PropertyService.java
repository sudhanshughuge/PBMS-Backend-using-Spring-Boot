package com.pbms.ProjectBackend.services;

import java.util.List;
import com.pbms.ProjectBackend.entities.Property;

public interface PropertyService {

	public int getMaxPropertyId();

	public List<Property> getProperties();
	
	public List<Property> getAvailableProperties();

	public Property getProperty(int PropID);

	public Property addProperty(Property property);

	public void updateProperty(Property property, int PropID);

	public void deleteProperty(int PropID);
	
}
