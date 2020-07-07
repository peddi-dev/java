package org.peddi.javase.collections.streams.exercises;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectoinToString {
	
	public void collectoinToString() {
		
		List<Integer> data = Arrays.asList(10,20,30,40);
		String sd = data.stream().map(Object::toString).collect(Collectors.joining(", "));
		System.out.println(sd);
		
	}

	public static void main(String[] args) {
		CollectoinToString app = new CollectoinToString();
		
		app.collectoinToString();
	}

}
