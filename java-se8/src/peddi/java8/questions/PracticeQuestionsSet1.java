package peddi.java8.questions;

public class PracticeQuestionsSet1 {
	//Q1 
	public class Employee{
		
		
		
		public int employeeId;
		public String firstName, lastName;
		public int yearStarted;
		@Override public int hashCode(){
			return employeeId;
		}
		public boolean equals(Employee e){
			return this.employeeId == e.employeeId;
		}
		
		public void demo(){
			System.out.println("====Employee====");
			Employee e1 = new Employee(), e2 = new Employee();
			e1.employeeId = 101;
			e2.employeeId = 101;
			
			System.out.println(e1.equals(e2)? "Success" : "Failure");
		}
	}
	
	//Q2 - Does it compile?
	public class Book{
		private int ISBN;
		private String title, authr;
		private int pageCount;
		@Override public int hashCode(){
			return ISBN;
		}
		
		@Override public boolean equals(Object o){
			if (! (o instanceof  Book))  return false;
			Book b = (Book) o;
			return this.ISBN == b.ISBN;
		}
	}
	
	//Q3 
	public class StringEqualsTest1{
		
		public void demo() {
			System.out.println("====StringEqualsTest1====");
			String s1 = "Canada";
			String s2 = new String(s1);
			
			if(s1 == s2)  
				System.out.println("s1==s2");
			
			if(s1.equals(s2)) 
				System.out.println(s1.equals(s2));
		}
	}
	
	//Q4
	public class BaseballTeam {
		private String city, mascot;
		private int numberOfPlayers;
		public boolean equals(Object o){
			if(! (o instanceof BaseballTeam) ){
				return false;
			}
			
			BaseballTeam bt = (BaseballTeam)o;
			return (city.equals(bt.city) && mascot.equals(bt.mascot) );
		}
		
		public int hashCode(){
			return numberOfPlayers;
		}
	}
	
	//Q5
//	public  class EnumTest{
//		
//		 enum Flavors {
//			VANILLA, CHOCOLATE, STRAWBERRY
//		}
//		
//		public void demo(){
//			System.out.println(Flavors.CHOCOLATE.ordinal());
//		}
//	}
	
	
}
