package com.webservices.restserv1;

import java.io.Serializable;

public class UserVO implements Serializable{
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
private String firstName;
private String lastName;
private String fullName;
private String mobileNumber1;

UserVO(){}

UserVO(String firstName, String lastName, String mobileNumber1)
{
	this.firstName = firstName;
	this.lastName = lastName;
	this.fullName = firstName+" "+lastName;
	this.mobileNumber1 = mobileNumber1;
}

public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public String getMobileNumber1() {
	return mobileNumber1;
}
public void setMobileNumber1(String mobileNumber1) {
	this.mobileNumber1 = mobileNumber1;
}

@Override
	public String toString() {
		// TODO Auto-generated method stub
		return firstName+", "+lastName+", "+fullName+", "+mobileNumber1+".";
	}
}
