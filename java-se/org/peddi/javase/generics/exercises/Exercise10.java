package org.peddi.javase.generics.exercises;

public class Exercise10 {
	//Will It compile: No
	// Error: Type mismatch: cannot convert from Node<Circle> to Node<Shape>
	public class Shape { /* ... */ }
	public class Circle extends Shape { /* ... */ }
	public class Rectangle extends Shape { /* ... */ }

	public class Node<T> { /* ... */ }
	
	public static void main(String[] args) {
		
		Exercise10 app = new Exercise10();
		
		Node<Circle> nc = app.new Node<>();
		// Error: Type mismatch: cannot convert from Node<Circle> to Node<Shape>
		// Node<Shape>  ns = nc;
	}

}
