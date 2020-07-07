package org.peddi.javase.generics;

public class GenericsRestrictions<T> {
	

	
	//Can not create static data members with type T
	//Error: can not make static reference to non-static type T
	//public static T d1;
	
	public void typeParamInstance() {
		// Can not create instances of type paramter T
		// Error: Can not instantiate type T
		// T data = new T();
	}
	
	
	// Extends Throwable indirectly
	// Error: The generic class GenericsRestrictions<T>.MathException<T> may not 
	// subclass java.lang.Throwable
	// class MathException<T> extends Exception { /* ... */ }    // compile-time error
	
	
	/**
	 * Parameterized type can be used in the throws clause
	 * @author peddi
	 *
	 * @param <T>
	 */
	class Parser<T extends Exception> {
	    public void demo( ) throws T {     // OK
	        // ...
	    }
	}
	
	public static void main(String[] args) {
		
	
	/**
	 * Can not instantiate generic types with primitive types
	 * 
     * Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
	 * Syntax error, insert "Dimensions" to complete TypeArgument
	 * Syntax error, insert "Dimensions" to complete ReferenceType
	 *  at javase/org.peddi.javase.generics.GenericsRestrictions.main(GenericsRestrictions.java:18)
	 */
	
	 //Pair<int, char> p1 = new OrderedPair<>(8, 'a');
		
	 
	}

}
