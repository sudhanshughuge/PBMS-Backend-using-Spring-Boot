package com.pbms.ProjectBackend.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	String resourceName;
	String fildName;
	long fieldValue;
	
	public ResourceNotFoundException(String resourceName, String fildName, long fieldValue) {
		super(String.format("%s not found with %s : %l", resourceName,fildName,fieldValue ));
		this.resourceName = resourceName;
		this.fildName = fildName;
		this.fieldValue = fieldValue;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getFildName() {
		return fildName;
	}

	public void setFildName(String fildName) {
		this.fildName = fildName;
	}

	public long getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(long fieldValue) {
		this.fieldValue = fieldValue;
	}
	
}
