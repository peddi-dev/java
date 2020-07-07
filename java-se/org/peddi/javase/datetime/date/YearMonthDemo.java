package org.peddi.javase.datetime.date;

import java.time.Month;
import java.time.YearMonth;
import static java.lang.System.out;

public class YearMonthDemo {
	
	public void yearMonthDemo() {
		
		YearMonth date1 =  YearMonth.now();
		out.printf(" YearMonth: %s, LengthOfMonth: %d%n", date1, date1.lengthOfMonth());
		
		YearMonth date2 = YearMonth.of(2020, Month.FEBRUARY);
		out.printf(" YearMonth: %s, LengthOfMonth: %d%n", date2, date2.lengthOfMonth());
		
		out.println(" is 2020 leap year: " + date2.isLeapYear());
	
		
	}
	
	
	public static void main(String[] args) {
		YearMonthDemo app = new YearMonthDemo();
		app.yearMonthDemo();
				
		
	}

}
