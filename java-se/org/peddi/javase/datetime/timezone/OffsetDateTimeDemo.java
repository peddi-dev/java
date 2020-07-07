package org.peddi.javase.datetime.timezone;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class OffsetDateTimeDemo {
	
	public void offsetDateTimeDemo() {
		
		LocalDateTime dt1 = LocalDateTime.of(2019, Month.DECEMBER, 24, 11, 20);
		ZoneOffset offset = ZoneOffset.of("-08:00");
		OffsetDateTime odt1 = OffsetDateTime.of(dt1, offset);
		System.out.println("OffsetDateTime: " + odt1);
		
	}

	public static void main(String[] args) {
		OffsetDateTimeDemo app = new OffsetDateTimeDemo();
		app.offsetDateTimeDemo();
		

	}

}
