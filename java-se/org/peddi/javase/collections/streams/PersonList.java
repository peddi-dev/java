package org.peddi.javase.collections.streams;

import java.util.List;
import java.util.ArrayList;
import java.time.Month;
import java.time.LocalDate;


public class PersonList {
	
	public PersonList() {
		
        this.members.add(new Person("AUser1", LocalDate.of(1970, Month.APRIL, 10), Person.Gender.MALE, "user1@abc.com","Bengaluru","Karnataka"));
        this.members.add(new Person("BUser2", LocalDate.of(1960, Month.JANUARY, 5), Person.Gender.MALE, "user2@abc.com","Mysuru","Karnataka"));
        this.members.add(new Person("CUser3", LocalDate.of(1980, Month.MAY, 10), Person.Gender.FEMALE, "user3@abc.com","Hyderbad","Telangana"));
        this.members.add(new Person("ZUser4", LocalDate.of(1975, Month.JUNE, 10), Person.Gender.MALE, "user4@abc.com","Amaravathi","AndhraPradesh"));
        this.members.add(new Person("XUser5", LocalDate.of(1990, Month.SEPTEMBER, 10), Person.Gender.FEMALE, "user5@abc.com","Chennai","Tamilnadu"));
        this.members.add(new Person("YUser6", LocalDate.of(1990, Month.AUGUST, 10), Person.Gender.MALE, "user6@abc.com","Trivendrum","Kerala"));
	}
	
	

	public List<Person> getMembers() {
		return members;
	}
	
	private List<Person> members = new ArrayList<>();

}
