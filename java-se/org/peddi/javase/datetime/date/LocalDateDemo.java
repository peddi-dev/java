package org.peddi.javase.datetime.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static java.lang.System.out;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.stream.Stream;

public class LocalDateDemo {
	
	public void localDateDemo() {
		
		LocalDate date1 = LocalDate.of(2019, 1, 1);
		
		out.println(date1.format(DateTimeFormatter.ISO_DATE));
		
		TemporalAdjuster adjuster = TemporalAdjusters.next(DayOfWeek.MONDAY);
		LocalDate date2 = date1.with(adjuster);
		out.println(date2);
		
		LocalDateTime dateTime1 = date1.atStartOfDay();
		out.println(dateTime1);
		
		out.println(ZoneId.systemDefault());
		ZonedDateTime dateTime2 = date1.atStartOfDay(ZoneId.systemDefault());
		out.println(dateTime2);
		//out.println(ZoneId.SHORT_IDS);
		//out.println(ZoneId.getAvailableZoneIds());
		
		
		LocalDateTime dateTime3 = date1.atTime(10, 30);
		out.println(dateTime3);
		
		
		out.println("datesUntil()");
		LocalDate current = LocalDate.now();
		LocalDate endDate = current.plusDays(10);
		Stream<LocalDate> dateStream1 = current.datesUntil(endDate);
		dateStream1.forEach(d -> out.println(d));
		
		out.println(  date1.get(ChronoField.DAY_OF_WEEK));
		
		out.println(date1.getChronology());
		out.println(date1.getDayOfWeek());
		
		out.println(date1.getEra());
		
		Period p = date1.until(LocalDate.now());    
		
		out.println(p);
	}
	
	public static void main(String[] args) {
		LocalDateDemo app = new LocalDateDemo();
		app.localDateDemo();
	}

}
