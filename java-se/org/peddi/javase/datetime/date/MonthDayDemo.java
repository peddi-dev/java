package org.peddi.javase.datetime.date;

import java.time.Month;
import java.time.MonthDay;

import static java.lang.System.out;

public class MonthDayDemo {
	
	public void monthDayDemo() {
		
		MonthDay d1 = MonthDay.of(Month.AUGUST, 15);
		out.println("India Independece Day: %s%n " + d1);
		
		
	}
	
	
	public static void main(String[] args) {
		MonthDayDemo app = new MonthDayDemo();
		app.monthDayDemo();
		
	}

}
