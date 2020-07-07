package org.peddi.javase.collections.streams;

import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import static java.lang.System.out;
public class StreamReductionCollectDemo {
	
	public class Averager implements IntConsumer {
		
		private int count = 0;
		private int total = 0;
		
		public double average() {
			return count > 0 ? total / count : 0;
		}

		@Override
		public void accept(int value) {
			System.out.println("Averager::accept");
			count++;
			total += value;
			
		}
		
		public void combine(Averager other) {
			System.out.println("Averager::combine");
			this.total += other.total;
			this.count += other.count;
		}
		
	}
	
	public double collectAverageDemo(List<Person> list) {
	
		
		Averager avgColl = list.stream().filter( p -> p.getGender() == Person.Gender.MALE)
					 .map(Person::getAge)
					 .collect(Averager::new, Averager::accept, Averager::combine);
		
		return avgColl.average();
	}
	
	public List<String> collectListDemo(List<Person> list){
		
		return list.stream()
		    .filter(p -> p.getGender() == Person.Gender.MALE)
		    .map(Person::getName)
		    .collect(Collectors.toList());
	}
	
	public Map<Person.Gender, List<Person>> collectByGroup(List<Person> list){
		
		return list.stream()
				   .collect(Collectors.groupingBy(Person::getGender));
		
	}
	
	public void collectByGroupDemo(List<Person> list) {
		
		Map<Person.Gender, List<Person>> result = collectByGroup(list);
		out.println("\nGroup By Gender");
		out.println(result);

	}
	
	public Map<Person.Gender, List<String>> collectByGroupAndDownstreamCollect(List<Person> list){
		
		return list.stream()
				   .collect(Collectors.groupingBy(Person::getGender,
						                          Collectors.mapping(Person::getName, Collectors.toList())));
		
	}
	
	public void collectByGroupAndDownstreamCollectDemo(List<Person> list) {
		
		 Map<Person.Gender, List<String>> result = collectByGroupAndDownstreamCollect(list);
		 out.println("\nGet names list with Group By Gender ");
		 out.println(result);
		
	}
	
	public Map<Person.Gender, Integer> collectSumOfAgesByGender(List<Person> list){
		
		return list.stream()
				   .collect(Collectors.groupingBy(Person::getGender,
						                          Collectors.reducing(0,Person::getAge, Integer::sum)
						                          )
						    );
		
	}
	
	public void collectSumOfAgesByGenderDemo(List<Person> list) {
		
		 Map<Person.Gender, Integer> result = collectSumOfAgesByGender(list);
		 
		 out.println("\n Sum og Ages with Group By Gender ");
		 out.println(result);
		
	}
	
	public Map<Person.Gender, Double> collectAverageAgesByGender(List<Person> list){
		
		return list.stream()
				   .collect(Collectors.groupingBy(Person::getGender,
						                          Collectors.averagingInt(Person::getAge)
						                          )
						    );
		
	}
	public void collectAverageAgesByGenderDemo(List<Person> list) {
		
		 Map<Person.Gender, Double> result = collectAverageAgesByGender(list);
		 out.println("\n Average Age with Group By Gender ");
		 out.println(result);
		
	}

	public static void main(String[] args) {
		
		PersonList pl = new PersonList();
		List<Person> list = pl.getMembers();
		
		StreamReductionCollectDemo app = new StreamReductionCollectDemo();
		double avg = app.collectAverageDemo(list);
		System.out.println("\nAverage age "+ avg);
		
		List<String> maleList = app.collectListDemo(list);
		System.out.println("\nMale list "+ maleList);
		
		app.collectByGroupDemo(list);
		app.collectByGroupAndDownstreamCollectDemo(list);
		app.collectSumOfAgesByGenderDemo(list);
		app.collectAverageAgesByGenderDemo(list);
		
		

	}

}
