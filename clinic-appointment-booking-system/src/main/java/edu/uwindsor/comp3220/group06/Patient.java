package edu.uwindsor.comp3220.group06;

import java.util.List;


public class Patient {
	private String healthCardID;
	private String name;
	private String DOB;
	private String phoneNumber;
	private String address;
	private String email;
	private List<String> healthRecord;

	
	public Patient(String healthCardID,
				   String name,
				   String DOB,
			       String phoneNumber,
				   String address,
				   String email,
				   List<String> healthRecord) {
		
		this.healthCardID = healthCardID;
		this.name = name;
		this.DOB = DOB;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.healthRecord = Null;
		
		
	}
	//Getters
	public String getHealthCardID(){
		return healthCardID;
	}
	public String getName(){
		return name;
	}
	
	public String getDOB(){
		return DOB;
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
	public void setHealthCardID(String healthCardID) {
		this.healthCardID = healthCardID;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDOB(String DOB) {
		this.DOB = DOB;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setEmail() {
		return email;
	}
	public void setHealthRecord() {
		return healthRecord;
	}
	
	
	
	@Override
	public String toString() {
		return "Patient Information: | Name: " + name + " | HealthCardID: " + healthCardID + " | DOB: " +
				DOB + " | Phone #: " + phoneNumber + " | Address: " + address + " | Email: " + email;
	}
	
	
}
		
	
	
	
	


