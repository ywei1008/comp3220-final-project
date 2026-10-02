package edu.uwindsor.comp3220.group06;

import java.util.List;


//patient class to store patient information
public class Patient {
	private String name;
	private String DOB;
	private String healthCardID;
	private String phoneNumber;
	private String address;
	private String email;
	private List<String> healthRecord;

	//constructor
	public Patient(String name,
				   String DOB,
				   String healthCardID,
			       String phoneNumber,
				   String address,
				   String email,
				   List<String> healthRecord) {
		
		this.name = name;
		this.DOB = DOB;
		this.healthCardID = healthCardID;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.healthRecord = healthRecord;	
	}

	//Getters
	public String getName(){
		return name;
	}
	
	public String getHealthCardID(){
		return healthCardID;
	}
	
	@Override
	public String toString() {
		return "Patient Information:"
				+ "\nName: " + name + 
				"\nDOB: " + DOB +
				"\nHealthCardID: " + healthCardID  + 
				"\nPhone #: " + phoneNumber + 
				"\nAddress: " + address + "\nEmail: " + email;
	}
}
		
	
	
	
	


