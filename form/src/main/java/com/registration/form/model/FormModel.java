package com.registration.form.model;

public class FormModel {
	 int id;
	 String username;
	 String name;
	 String email;
	public FormModel(int id, String username, String name, String email) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	 
}
