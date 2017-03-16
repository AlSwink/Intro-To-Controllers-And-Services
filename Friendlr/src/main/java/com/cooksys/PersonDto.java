package com.cooksys;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonDto {

	@NotNull
	@Size(min = 2, max = 100)
	private String fName;
	
	@NotNull
	@Size(min = 2, max = 100)
	private String lName;
	
	private List<Long> friendID;

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

	public List<Long> getFriendID() {
		return friendID;
	}

	public void setFriendID(List<Long> friendID) {
		this.friendID = friendID;
	}
	
	
}
