package com.glarimy.bank.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerDetail {
	private String name;
	@Id
	private String adharNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

}
