package org.peddi.javase.datetime.temporal;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

import static java.lang.System.out;

public class TemporalAdjusterDemo {
	
	public void temporalAdjusterDemo() {
		
		out.println("\nPredfeined Adjusters");
		
		LocalDate date = LocalDate.of(2019, Month.AUGUST, 15);
		
		DayOfWeek dow = date.getDayOfWeek();
		out.printf("%s is on %s %n", date, dow);
		
		LocalDate date2 = date.with(TemporalAdjusters.firstDayOfMonth());
		out.printf("firstDayOfMonth of %s is %s %n", date, date2);
		
		LocalDate date3 = date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
		out.printf("first Monday of month in  %s is %s %n", date, date3);
		
		LocalDate date4 = date.with(TemporalAdjusters.firstDayOfNextMonth());
		out.printf("first day of next month with  %s is %s %n", date, date4);
		
		LocalDate date5 = date.with(TemporalAdjusters.lastDayOfYear());
		out.printf("last day of year with  %s is %s %n", date, date5);
		
		LocalDate date6 = date.with(TemporalAdjusters.firstDayOfNextYear());
		out.printf("first day of next year with  %s is %s %n", date, date6);
	}
	
	public void customTemporalAdjusterDemo() {
		
		out.println("\nCustom Adjuster");
		
		NextPayDayTemporalAdjuster payDayAdjuster = new NextPayDayTemporalAdjuster();
		LocalDate date = LocalDate.of(2013, Month.JUNE, 12);
		LocalDate payDay = date.with(payDayAdjuster);
		out.printf("Next Pay Day for %s is %s %n", date, payDay);
		
		LocalDate date2 = LocalDate.of(2013, Month.JUNE, 22);
		LocalDate payDay2 = date2.with(payDayAdjuster);
		out.printf("Next Pay Day for %s is %s %n", date2, payDay2);
		
	}

	public static void main(String[] args) {
		TemporalAdjusterDemo app = new TemporalAdjusterDemo();
		app.temporalAdjusterDemo();
		app.customTemporalAdjusterDemo();
	}

}
