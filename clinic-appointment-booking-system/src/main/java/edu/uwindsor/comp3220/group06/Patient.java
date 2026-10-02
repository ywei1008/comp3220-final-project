package edu.uwindsor.comp3220.group06;

import java.util.List;


public class Patient {
	private String name;
	private String DOB;
	private String healthCardID;
	private String phoneNumber;
	private String address;
	private String email;
	private List<String> healthRecord;

	
	
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
	
	public String getDOB(){
		return DOB;
	}
	
	public String getHealthCardID(){
		return healthCardID;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	public String getAddress(){
		return address;
	}
	
	
	public List<String> getHealthRecord(){
		return healthRecord;
	}
	
	
	//Setters
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDOB(String DOB) {
		this.DOB = DOB;
	}
	
	public void setHealthCardID(String healthCardID) {
		this.healthCardID = healthCardID;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setHealthRecord(List<String> healthRecord) {
		this.healthRecord = healthRecord;
	}
	
	
	
	@Override
	public String toString() {
		return "Patient Information: | Name: " + name + " | DOB: " +
				DOB + " | HealthCardID: " + healthCardID  + " | Phone #: " + phoneNumber + " | Address: " + address + " | Email: " + email;
	}
	
	
}
		
	
	
	
	


