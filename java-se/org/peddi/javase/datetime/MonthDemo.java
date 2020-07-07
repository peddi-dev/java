package org.peddi.javase.datetime;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class MonthDemo {
	
	public void monthDemo() {
		
		for(Month m: Month.values()) {
			
			System.out.format("%2d, %10s %s %s %n",  
					m.getValue(),
					m.getDisplayName(TextStyle.FULL, Locale.getDefault()),
					m.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
					m.getDisplayName(TextStyle.NARROW, Locale.getDefault())
					
					);
			
		}
		
	}
	
	public static void main(String[] args) {
		MonthDemo app = new MonthDemo();
		app.monthDemo();
		
	}

}
