package org.peddi.javase.datetime;

import java.time.DayOfWeek;
import java.time.format.TextStyle;

import static java.lang.System.out;
import java.util.Calendar;
import java.util.Locale;

public class DayOfWeekDemo {

	public void dayOfWeekDemo() {
		
		for( DayOfWeek d : DayOfWeek.values()) {
			
			out.format("%d %10s , %s, %s %n", 
					d.getValue(), 
					d.getDisplayName(TextStyle.FULL, Locale.getDefault()),
					d.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
					d.getDisplayName(TextStyle.NARROW, Locale.getDefault())
					
					);

		}
		
	}
	
	public static void main(String[] args) {
		DayOfWeekDemo app = new DayOfWeekDemo();
		app.dayOfWeekDemo();
		
		
	}
	
}
