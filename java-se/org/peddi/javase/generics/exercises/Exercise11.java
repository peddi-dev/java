package org.peddi.javase.generics.exercises;

public class Exercise11 {
	
	class Node<T> implements Comparable<T> {
	    public int compareTo(T obj) { 
	    	/* ... */ 
	    	 return 0;
	    }
	    // ...
	   
	}
	
	public static void main(String[] args) {
		Exercise11 app = new Exercise11();
		Node<String> node = app.new Node<>();
		Comparable<String> comp = node;
	}

}
