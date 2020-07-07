package org.peddi.javase.generics.wildcaard;

import java.util.*;

public class LowerBoundWildcardDemo {
	
	public static void add(List<? super Integer> list) {
		
		for( int i=0; i <= 10 ; i++) {
			list.add(i);
		}
	}
	
	public static void main(String[] args) {
		
		List<Integer> li = new ArrayList<>();
		add(li);
		System.out.println(li);
		
		List<Number> ln = new ArrayList<>();
		add(ln);
		System.out.println(ln);
	}

}
