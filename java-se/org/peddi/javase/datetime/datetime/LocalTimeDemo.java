package org.peddi.javase.datetime.datetime;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ValueRange;

import static java.lang.System.out;

public class LocalTimeDemo {
	
	public void localTimeDemo() {
		 LocalTime time1 = LocalTime.now();
		 out.printf("Time %1$tH:%1$tM:%1$tS %n",time1);
		 // < gets the argument (1$) from the previous format specifier (i.e., 1$ in this example)
		 out.printf("Time %1$tH:%<tM:%<tS %n",time1);
		 
		 out.println("Hours: " + time1.getHour());
		 out.println("Minutes: " + time1.getMinute());
		 out.println("Seconds: " + time1.getSecond());
		 out.println("Nanos: " + time1.getNano());
		 
		 LocalTime time2 = time1.withHour(2);
		 out.println(time2);
		 out.println(time1);
		 
		 ValueRange vr = time1.range(ChronoField.MINUTE_OF_HOUR);
		 out.println("ValueRange: " + vr);
	}
	
	public static void main(String[] args) {
		LocalTimeDemo app = new LocalTimeDemo();
		app.localTimeDemo();
		
	}

}
