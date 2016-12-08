package com.niit.sweetcake.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Role {

	@Id
	private String ROLE_ID;
	@Column(name = "ROLE_NAME")
	private String ROLE_USER = "ROLE_USER";

	private String USERNAME;

	private String ENABLED = "true";

	public Role() {
		ROLE_ID = "role_Id" + UUID.randomUUID().toString().substring(34).toUpperCase();
	}

	public String getROLE_ID() {
		return ROLE_ID;
	}

	public void setROLE_ID(String rOLE_ID) {
		ROLE_ID = rOLE_ID;
	}

	public String getROLE_USER() {
		return ROLE_USER;
	}

	public void setROLE_USER(String rOLE_USER) {
		ROLE_USER = rOLE_USER;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getENABLED() {
		return ENABLED;
	}

	public void setENABLED(String eNABLED) {
		ENABLED = eNABLED;
	}

}
