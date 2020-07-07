package org.peddi.javase.generics.wildcaard;

import java.util.Arrays;
import java.util.List;
public class UpperBoundWildCardDemo {
	
	public static double sum(List<? extends Number> list) {
		double result = 0;
		for( Number n : list) {
			result += n.doubleValue();
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(10, 20, 30); 
		double sum = sum(l1);
		System.out.println(sum);
		
		List<Double> l2 = Arrays.asList(4.6, 2.3, 5.2);
		sum= sum(l2);
		System.out.println(sum);
		
	}

}
