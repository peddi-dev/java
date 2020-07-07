package org.peddi.javase.generics.exercises;

import java.util.Arrays;
import java.util.List;

public class Exercise7 {
	
	//Will it compile : yes
	public static void print(List<? extends Number> list) {
	    for (Number n : list)
	        System.out.print(n + " ");
	    System.out.println();
	}
	
	public static void main(String[] args) {
		List<Integer> il = Arrays.asList(10,10,30);
		print(il);
	}

}
