package org.peddi.javase.datetime.timezone;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetTime;
import java.time.ZoneOffset;

public class OffsetTimeDemo {
	
	public void offsetTimeDemo() {
		
		LocalTime t1 = LocalTime.of(8, 30, 10);
		ZoneOffset offset = ZoneOffset.of("-08:00");
		OffsetTime ot1 = OffsetTime.of(t1, offset);
		System.out.println("OffsetTime : " + ot1);
	}
	
	public static void main(String[] args) {
		OffsetTimeDemo app = new OffsetTimeDemo();
		app.offsetTimeDemo();
	}

}
