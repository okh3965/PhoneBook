package com.java.phone;

public class Person {
	
	//field
	String name;
	String mobilePhoneNum;
	String PhoneNum;
	
	//constructor
	public Person(String name, String mobilePhoneNum, String PhoneNum) {
		this.name = name;
		this.mobilePhoneNum = mobilePhoneNum;
		this.PhoneNum = PhoneNum;
	}

	@Override
	public String toString() {
		return name + " " +
				mobilePhoneNum + " " + 
				PhoneNum;
	}
	
//2021.03.12
	
	
}
