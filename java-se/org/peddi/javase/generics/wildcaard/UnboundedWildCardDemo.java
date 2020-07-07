package org.peddi.javase.generics.wildcaard;

import java.util.*;

public class UnboundedWildCardDemo {
	
	public static void print(List<?> list) {
		
		for(Object elem: list) {
			System.out.println(elem);
		}
		
		
		
	}
	
	public static void main(String[] args) {
		
		List<Integer> li = Arrays.asList(10, 20, 30);
		print(li);
		
		System.out.println();
		
		List<String> ls = Arrays.asList("Mon", "Tue", "Wed");
		print(ls);
		
	}

}
