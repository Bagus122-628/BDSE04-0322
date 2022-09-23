package com.abcjob.login;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_users")
public class LoginUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_user;
	
	private String email;
	private String password;
	private Boolean enabled;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	private LoginProfile profile;

	public LoginUser() {

	}
	
	public LoginUser(String email, String password, Boolean enabled, LoginProfile profile) {
		super();
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.profile = profile;
	}

	public long getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginProfile getProfile() {
		return profile;
	}

	public void setProfile(LoginProfile profile) {
		this.profile = profile;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
}
