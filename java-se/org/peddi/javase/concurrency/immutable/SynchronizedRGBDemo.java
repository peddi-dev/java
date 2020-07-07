package org.peddi.javase.concurrency.immutable;

public class SynchronizedRGBDemo {

	public static void main(String[] args) {
		
		SynchronizedRGB color = new SynchronizedRGB(0, 0, 0, "Pitch Black");
		
		//following two statements need to be synchronized. Other if another thread invokes
		//color.set() method after statement 1 and before statement 2, then myColorInt won't
		// match with the myColorName
		synchronized(color) {
			int myColorInt = color.getRGB();
			String myColorName = color.getName();
		}
		

	}

}
