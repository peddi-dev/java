package org.peddi.javase.datetime.temporal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.ZoneOffset;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;

import static java.lang.System.out;

public class TemporalQueryDemo {
	
	public void temporalQueryDemo() {
		
		TemporalQuery precisionQuery = TemporalQueries.precision();
		
		out.println("Predeined temporal queries");
		LocalDate date = LocalDate.now();
		out.printf("Precisoin for LocalDate is %s%n" , date.query(precisionQuery));
		
		LocalDateTime dateTime = LocalDateTime.now();
		out.printf("Precision for LocalDateTime is %s%n", dateTime.query(precisionQuery));
		
		MonthDay md = MonthDay.now();
		out.printf("Precision for MonthDay is %s%n", md.query(precisionQuery));
		
		ZoneOffset zo = ZoneOffset.UTC;
		out.printf("Precision for ZoneOffset is %s%n", zo.query(precisionQuery));
		
		
	}
	
	public void customTemporaQueryDemo() {
		
		CustomTemporalQueryIndiaRepublicHolidays query = new CustomTemporalQueryIndiaRepublicHolidays();
		
		out.println("\nCustom Temporal Query");
		LocalDate date1 = LocalDate.of(2019, Month.JANUARY, 26);
		out.printf("check is Indian Republic Holiday on %s : %s %n", date1, date1.query(query));
		
		LocalDate date2 = LocalDate.of(2019, Month.JANUARY, 30);
		out.printf("check is Indian Republic Holiday on %s : %s %n", date2, date2.query(query));
	}
	
	public static void main(String[] args) {
		TemporalQueryDemo app = new TemporalQueryDemo();
		app.temporalQueryDemo();
		app.customTemporaQueryDemo();
	}
}
