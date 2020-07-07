package org.peddi.javase.datetime.date;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class InstantDemo {
	
	public void  instantDemo() {
		
		Instant i1 = Instant.now();
		System.out.println(i1);
		
		Instant i2 = Instant.ofEpochSecond(10);
		System.out.println(i2);
		
		System.out.println("ChronoField.NANO_OF_SECOND: " + i2.isSupported(ChronoField.NANO_OF_SECOND));
		System.out.println("ChronoField.INSTANT_SECONDS: " + i2.isSupported(ChronoField.INSTANT_SECONDS));
		
		System.out.println("\nChronoUnit.NANOS: "+ i2.isSupported(ChronoUnit.NANOS));
		System.out.println("ChronoUnit.HALF_DAYS: "+ i2.isSupported(ChronoUnit.HALF_DAYS));
		System.out.println("ChronoUnit.DAYS: "+ i2.isSupported(ChronoUnit.DAYS));
		
		System.out.println("compareTo():" + i1.compareTo(i2));
		System.out.println("compareTo():" + i1.isAfter(i2));
	}

	public static void main(String[] args) {
		InstantDemo app = new InstantDemo();
		app.instantDemo();

	}

}
