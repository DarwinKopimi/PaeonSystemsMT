package com.ps.webservice.data;




public class Patient  {
	
	private String Id;
	private String firstName;
	private String lastName;
	private String DateOfBirth;
	private int age;
	private String HealthInsurance;
	private String userName;
	private String password;
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getDateOfBirth() {
		return DateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}




	public String getHealthInsurance() {
		return HealthInsurance;
	}


	public void setHealthInsurance(String healthInsurance) {
		HealthInsurance = healthInsurance;
	}


	
	

	public void login(String userName, String password) {
		// TODO Auto-generated method stub
		
	}

}
