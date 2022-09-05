package com.bean;

public class RegisterBean {

	private String email;
	private String password;
	private String first_name;
	private String last_name;
	private String country;
	private String city;
	
	public RegisterBean(String email, String password, String first_name, String last_name, String country, String city) {
		this.email = email;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.country = country;
		this.city = city;
	}

	// email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// password
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// first name
	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	// last name
	public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	// country
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	// city
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
