package org.peddi.javase.concurrency.immutable;


/**
 * 
 * 
 * Guidelines for writing immutable classes
1. Don't provide "setter" methods — methods that modify fields or objects referred to by fields.
2. Make all fields final and private.
3. Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final. A more sophisticated approach is to make the constructor private and construct instances in factory methods.
4. If the instance fields include references to mutable objects, don't allow those objects to be changed:
	Don't provide methods that modify the mutable objects.
	Don't share references to the mutable objects. Never store references to external, mutable objects passed to the constructor; if necessary, create copies, and store references to the copies. Similarly, create copies of your internal mutable objects when necessary to avoid returning the originals in your methods.
 * 
 * @author peddi
 *
 */

final public class ImmutableRGB {
	
	final private int red;
	final private int green;
	final private int blue;
	final private String name;
	
	private void check(int r, int g, int b) {
		
		boolean result = r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255;
		if(result) {
			throw new IllegalArgumentException();
		}
	}
	
	public ImmutableRGB(int r, int g, int b, String name) {
		check(r,g,b);
		
		this.red = r;
		this.green = g;
		this.blue = b;
		this.name = name;
		
	}
	
	public  synchronized int getRGB() {
		return ((red << 16) | (green << 8) | (blue));
	}
	
	public synchronized String getName() {
		return this.name;
	}
	
	public  ImmutableRGB invert() {
		
		return new ImmutableRGB(255 - this.red,
				255 - this.green,
				255 - this.blue,
				"Inverse Of " + name
				);
		
	}
}
