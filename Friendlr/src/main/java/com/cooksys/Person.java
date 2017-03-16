package com.cooksys;

import java.util.List;


public class Person {
	
	private Long ID;
	private String fName;
	private String lName;
	private List<Person> friends;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
    public Person(String fName, String lName) {
    	this.fName = fName;
    	this.lName = lName;
    }

    public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public List<Person> getFriends() {
		return friends;
	}
	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}
}
