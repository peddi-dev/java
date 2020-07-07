package org.peddi.javase.datetime.date;

import java.time.Year;
import static java.lang.System.out;

public class YearDemo {
	
	
	public void yearDemo() {
		
		Year y1 = Year.now();
		out.printf("Year.now(): %s%n", y1);
		
		Year y2 = Year.of(2010);
		out.println("2010 - isLeapYer(): " + y1.isLeap());
		
		
	}
	
	public static void main(String[] args) {
		YearDemo app = new YearDemo();
		app.yearDemo();
	}

}
