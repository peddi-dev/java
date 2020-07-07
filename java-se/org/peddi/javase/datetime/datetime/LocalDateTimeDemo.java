package org.peddi.javase.datetime.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;

import static java.lang.System.out;

public class LocalDateTimeDemo {
	
	public void localDateTimeDemo() {
		LocalDateTime dateTime1 = LocalDateTime.now();
		out.println("LocalDateTime: "+ dateTime1);
		
		LocalDateTime dt2 = LocalDateTime.of(2019, Month.DECEMBER, 10, 8, 5);
		out.println(dt2);
		
		LocalDateTime dt3 = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
		out.println("LocalDateTime from Instant :" + dt3);
		
	}

	public static void main(String[] args) {
		LocalDateTimeDemo app = new LocalDateTimeDemo();
		app.localDateTimeDemo();
	}

}
