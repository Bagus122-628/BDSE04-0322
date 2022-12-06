package com.lithan.a5.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_store")
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_store")
	private int id_store;

	@Column(name = "name")
	private String name;

	@Column(name = "phone_number")
	private String phone_number;

	@Column(name = "localities")
	private String localities;

	public Store() {

	}

	public Store(String name, String phone_number, String localities) {
		this.name = name;
		this.phone_number = phone_number;
		this.localities = localities;
	}

	public int getId_store() {
		return id_store;
	}

	public void setId_store(int id_store) {
		this.id_store = id_store;
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
