package org.peddi.javase.generics;

/**
 * generic type is a type(class/interface) that is parameterised over types
 * 
 * @author peddi
 *
 */
public class GenericsDemo {

	public static void main(String[] args) {
		
		
		// Integer is argument to the type parameter T
		// diamond(<>) syntax uses type inference
		Box<Integer> intBox = new Box<>();
		
		//raw type
		Box  b = new Box();
		
		// String is type argument to the type parameter K
		// Integer is type argument to the type parameter V
		Pair<String, Integer> p = new OrderedPair<>();
	}

}
