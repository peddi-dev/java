package peddi.java8.nested;

public class StaticNestedClassDemo {
	public static class Nested{
		private int data = 10;		
	}
	
	public void demo(){
		Nested nested = new Nested();
		System.out.println("Nested.data: " + nested.data);
	}
}
