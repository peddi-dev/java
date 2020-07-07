package org.peddi.javase.collections.streams;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Person {
	
	public enum Gender {
		MALE, FEMALE
	}
	public Person() {}
	
	public Person(String name, LocalDate birthDay, Gender gender, String emailId, String city, String state) {
		super();
		this.name = name;
		this.birthDay = birthDay;
		this.gender = gender;
		this.emailId = emailId;
		this.city = city;
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", birthDay=" + birthDay + ", gender=" + gender + ", emailId=" + emailId
				+ ", city=" + city + ", state=" + state + "]";
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public int getAge() {
		
		if (this.getBirthDay() == null ) return 0;
		
		
		int age = 0;
		//Solution 1
//		Period period = Period.between( this.getBirthDay(), LocalDate.now());
//		age =  period.getYears();
		
		//Solution 2
		age = (int) ChronoUnit.YEARS.between(this.getBirthDay(), LocalDate.now());
		
		return age;
		
	}
	

	private String name;
	private LocalDate birthDay;
	private Gender gender;
	private String emailId;
	private String city;
	private String state;
	
	
}
