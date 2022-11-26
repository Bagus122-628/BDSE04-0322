package com.lithan.a3.entity;

public class Store {

	private String name;
	private String phone_number;
	private String localities;
	
	public Store() {
		
	}

	public Store(String name, String phone_number, String localities) {
		this.name = name;
		this.phone_number = phone_number;
		this.localities = localities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getLocalities() {
		return localities;
	}

	public void setLocalities(String localities) {
		this.localities = localities;
	}

}
