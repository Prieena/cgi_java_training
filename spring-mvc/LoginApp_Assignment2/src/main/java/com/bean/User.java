package com.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class User {

	private String emailId;
	public User(String emailId, String password, String typeOfUser) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.typeOfUser = typeOfUser;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTypeOfUser() {
		return typeOfUser;
	}
	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}
	private String password;
	private String typeOfUser;
}
