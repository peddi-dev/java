package org.peddi.javase.collections.streams;

import java.util.List;
import java.util.stream.Stream;

//import static java.lang.System.out.*;

public class StreamBasicDemo {
	
	/**
	 * print all persons
	 * @param list
	 */
	public void forEachDemo(List<Person> list) {
		System.out.println("forEachDemo()");
		list.stream().forEach(p -> System.out.println(p.getName()));
		
	}
	
	/**
	 * print all MALE members
	 * @param list
	 */
	public void filterDemo(List<Person> list) {
		System.out.println("filterDemo()");
		list.stream().filter(p -> p.getGender() == Person.Gender.MALE).forEach(p -> System.out.println(p.getName()));
		
	}
	
	public double averageDemo(List<Person> list) {
		return list.stream().mapToInt(Person::getAge).average().getAsDouble();
	}
	
	public static void main(String[] args) {
		
		StreamBasicDemo app = new StreamBasicDemo();
		PersonList pl = new PersonList();
		List<Person> list = pl.getMembers();
		
		
		app.forEachDemo(list);
		app.filterDemo(list);
		double averageAge = app.averageDemo(list);
		System.out.println("Average Age:" + averageAge);
		
		
		
	}

}
