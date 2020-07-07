package org.peddi.javase.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.Period;

import static java.lang.System.out;

public class DurationPeriodDemo {
	
	public void durationDemo() {
		LocalDateTime dt1 = LocalDateTime.of(2019, Month.DECEMBER, 1, 10, 30);
		Instant i1 = dt1.toInstant(ZoneOffset.ofHoursMinutes(5,30));
		LocalDateTime dt2 = LocalDateTime.of(2019, Month.DECEMBER, 3, 11, 30);
		Instant i2 = dt2.toInstant(ZoneOffset.ofHoursMinutes(5,30));
		
		out.println("Duration Demo");
		out.printf("Duration bewteen %s and %s is %s days %n", i1, i2, Duration.between(i1, i2));
		
		Duration gap = Duration.ofMinutes(30);
		Instant current = Instant.now();
		Instant later = current.plus(gap);
		out.printf("%s  30 mins after becomes %s%n", current, later);
		
		
	}
	
	public void chronoUnitBetween() {
		
		LocalDate d1 = LocalDate.of(2019, Month.SEPTEMBER, 1);
		LocalDate d2 = LocalDate.of(2019, Month.SEPTEMBER, 3);
		
		long gap = ChronoUnit.DAYS.between(d1, d2);
		out.println("\nChronoUnit.between()");
		out.printf("Gap is %d days%n", gap);
		
	
	}
	
	public void periodDemo() {
		
		out.println("\nPediod Demo");
		LocalDate debtTakenDate = LocalDate.of(2012, Month.MAY, 12);
		LocalDate today = LocalDate.now();
		Period debtPeriod =  Period.between(debtTakenDate, today);
		out.printf("Debt taken Period from %s to  %s(today) is %s%n", debtTakenDate, today, debtPeriod);
	
	}

	public static void main(String[] args) {
		
		DurationPeriodDemo app = new DurationPeriodDemo();
		app.durationDemo();
		app.chronoUnitBetween();
		app.periodDemo();
	}

}
