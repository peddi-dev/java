package org.peddi.javase.datetime.timezone;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeDemo {
	
	public void zonedDateTimeDemo() {
		
		LocalDateTime dt1 = LocalDateTime.of(2019, Month.DECEMBER, 24, 11, 20);
		ZoneId zone = ZoneId.of("America/Los_Angeles");
		ZonedDateTime zdt1 = ZonedDateTime.of(dt1, zone);
		System.out.println("ZonedDateTime: " + zdt1);
	}

	public static void main(String[] args) {
		
		ZonedDateTimeDemo app = new ZonedDateTimeDemo();
		app.zonedDateTimeDemo();

	}

}
