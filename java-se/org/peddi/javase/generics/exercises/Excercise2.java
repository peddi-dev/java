package org.peddi.javase.generics.exercises;

public class Excercise2 {
	
	 /**
	  *
	  * Error: The operator > is undefined for the argument type(s) T, T	
	  * 
	  * 
	  * @param <T>
	  * @param x
	  * @param y
	  * @return
	  */
	  public static <T> T max(T x, T y) {
	       // return x > y ? x : y;
		  return x;
	    }

}
