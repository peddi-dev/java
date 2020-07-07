package org.peddi.javase.concurrency.immutable;

public class SynchronizedRGB {
	// values must be between 0 and 255
	private int red;
	private int green;
	private int blue;
	private String name;
	
	private void check(int r, int g, int b) {
		
		boolean result = r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255;
		if(result) {
			throw new IllegalArgumentException();
		}
	}
	
	public SynchronizedRGB(int r, int g, int b, String name) {
		check(r,g,b);
		
		this.red = r;
		this.green = g;
		this.blue = b;
		this.name = name;
		
	}
	
	public void set(int r, int g, int b, String name) {
		check(r,g,b);
		synchronized(this){
			this.red = r;
			this.green = g;
			this.blue = b;
			this.name = name;
		}
	}
	
	public  synchronized int getRGB() {
		return ((red << 16) | (green << 8) | (blue));
	}
	
	public synchronized String getName() {
		return this.name;
	}
	
	public synchronized void invert() {
		this.red = 255 - this.red ;
		this.green = 255- this.green ;
		this.blue = 255 - this.blue ;
		this.name = "Inverse Of " + name ;
	}

}
