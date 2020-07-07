package org.peddi.javase.collections.streams.parallel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.peddi.javase.collections.streams.Person;
import org.peddi.javase.collections.streams.PersonList;
import static java.lang.System.out;

public class ParallelStreamsDemo {
	
	public double averageAge(List<Person> list) {
		
		return list.parallelStream()
				   .filter(p -> p.getGender() == Person.Gender.MALE)
				   .mapToInt(Person::getAge)
				   .average().getAsDouble();
				   
		
	}
	
	public Map<Person.Gender, List<Person>> concurrentReductionGroupByGender(List<Person> list){
		
		return list.parallelStream().collect(Collectors.groupingByConcurrent(Person::getGender));
		
	}
	
	public void concurrentReductionGroupByGenderInvoker(List<Person> list) {
		
		Map<Person.Gender, List<Person>> result = concurrentReductionGroupByGender(list);
		out.println("\nconcurrentReductionGroupByGenderInvoker");
		out.println(result);
		
	}
	
	public void orderingDemo() {
		List<Integer> il = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		Comparator<Integer> natural = Integer::compare;
		Comparator<Integer> reversed = natural.reversed();
		Collections.sort(il, reversed);
		
		out.println("\nsequential stream - forEach");
		il.stream().forEach(e -> out.printf(e + " "));
		
		out.println("\nparallel stream - forEach - traverse 1");
		il.parallelStream().forEach(e -> out.printf(e + " "));
		
		out.println("\nparallel stream - forEach - traverse 2");
		il.parallelStream().forEach(e -> out.printf(e + " "));
		
		out.println("\nparallel stream - forEachOrdered  ");
		il.parallelStream().forEachOrdered(e -> out.printf(e + " "));
		
	}
	
	public void interferenceDemo() {
		
		try {
			List<String> list = new ArrayList<>(Arrays.asList("one", "two"));
			
			list.stream()
				//Don't do this, interference occurs here
			    .peek(s -> list.add("three"))
			    .reduce((a,b) -> a + " " + b)
			    .get();
			
		}catch(ConcurrentModificationException e) {
			out.println("\n\n Exception in interference() ");
			e.printStackTrace();
			
		}
		
	}
	
	public void statefulLambdaExpressionDemo() {
		
		List<Integer> il = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		
		Comparator<Integer> natural = Integer::compare;
		Comparator<Integer> reversed = natural.reversed();
		
		Collections.sort(il, reversed);
		
		List<Integer> serialStorage = new ArrayList<>();
		
		out.println("\n\nSerial Pipeline Output ");
		il.stream()
		  // Don't do this, it uses stateful lambda expression
		  .map(e ->{serialStorage.add(e); return e;})
		  .forEach(e -> out.print(e + " "));
		 
		out.println("\n\nSerial Storage ");
		
		serialStorage.stream()
		             .forEach(e -> out.print(e + " "));
		
		
		
		
		List<Integer> parallelStorage = Collections.synchronizedList(new ArrayList<>()) ;
		
		out.println("\n\nParallel Pipeline Output ");
		il.parallelStream()
		  // Don't do this, it uses stateful lambda expression
		  .map(e ->{parallelStorage.add(e); return e;})
		  .forEachOrdered(e -> out.print(e + " "));
		 
		out.println("\n\nParallel Storage ");
		
		parallelStorage.parallelStream()
		             .forEach(e -> out.print(e + " "));
		
	}
	

	
	public static void main(String[] args) {
		ParallelStreamsDemo app = new ParallelStreamsDemo();
		
		PersonList pl = new PersonList();
		List<Person> list = pl.getMembers();
		
		out.println( "Average Age: " + app.averageAge(list) );
		
		app.concurrentReductionGroupByGenderInvoker(list);
		
		app.orderingDemo();
		
		app.interferenceDemo();
		
		app.statefulLambdaExpressionDemo();
		
	}

}
