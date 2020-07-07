package org.peddi.javase.collections.streams;

import java.util.List;

public class StreamReductionReduceDemo {
	
	public double reduceDemo(List<Person> list) {
		
		return list.stream().map(Person::getAge).reduce(0, (x, y) -> x + y  );
	}
	
	public static void main(String[] args) {
		StreamReductionReduceDemo app = new StreamReductionReduceDemo();
		PersonList pl = new PersonList();
		List<Person> list = pl.getMembers();
		
		 double sum = app.reduceDemo(list);
		 System.out.println("Age Sum: " + sum);
	}

}
