package com.rbsbootldapsecurity.entity;

public class User {
	
	public User() {
		super();
	}
	public User(long id, String name, String contact, String address, String status, String creationDate) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.address = address;
		this.status = status;
		this.creationDate = creationDate;
	}
	long id;
	String name;
	String contact;
	String address;
	String status;
	String creationDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, contact=%s, address=%s, status=%s, creationDate=%s]", id, name,
				contact, address, status, creationDate);
	}
	
	

}
