package com.abcjob.register;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user_profile")
public class RegisterProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_profile;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user")
	private RegisterUser user;
	
	@ManyToOne
	@JoinColumn(name = "id_job")
	private RegisterJob job;
	
	private String first_name;
	private String last_name;
	private String country;
	private String city;
	
	public RegisterProfile() {

	}
	
	public RegisterProfile(RegisterUser user, RegisterJob job, String first_name, String last_name, String country,
			String city) {
		super();
		this.user = user;
		this.job = job;
		this.first_name = first_name;
		this.last_name = last_name;
		this.country = country;
		this.city = city;
	}

	public int getId_profile() {
		return id_profile;
	}

	public void setId_profile(int id_profile) {
		this.id_profile = id_profile;
	}

	public RegisterUser getUser() {
		return user;
	}

	public void setUser(RegisterUser user) {
		this.user = user;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public RegisterJob getJob() {
		return job;
	}

	public void setJob(RegisterJob job) {
		this.job = job;
	}
	
}
