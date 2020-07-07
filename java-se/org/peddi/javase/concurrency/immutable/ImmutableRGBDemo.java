package org.peddi.javase.concurrency.immutable;

public class ImmutableRGBDemo {
	
	public static void main(String[] args) {
		
		ImmutableRGB color = new ImmutableRGB(0,0,0,"Pitch Black");
		
		// followng two statements do not need synchronization. 
		// color object is immutable, there won't be inconsistent state for this object with multiple threads
		int myColorInt = color.getRGB();
		String myColorString = color.getName();
	}

}
