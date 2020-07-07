package org.peddi.javase.datetime.temporal;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class NextPayDayTemporalAdjuster implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {
		
		LocalDate payDay = null;
		
		
		try {
			
			int day = 0;
			LocalDate date = LocalDate.from(temporal);
			
			if(date.getDayOfMonth() < 15) {
				day = 15;
			}else {
				
			LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
			  day = lastDay.getDayOfMonth();
			}
			
			payDay = date.withDayOfMonth(day);
			DayOfWeek dow = payDay.getDayOfWeek();
			//LocalDate payDay = temp;
			
			if ( dow == DayOfWeek.SATURDAY || dow == DayOfWeek.SUNDAY) {
				
				payDay = payDay.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
				
			}
			
		}catch(DateTimeException e) {
			e.printStackTrace();
			throw e;
		}
		
		return payDay;
		
	}

}
