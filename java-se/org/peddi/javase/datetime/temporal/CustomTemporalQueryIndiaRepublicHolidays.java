package org.peddi.javase.datetime.temporal;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

public class CustomTemporalQueryIndiaRepublicHolidays implements TemporalQuery<Boolean> {

	@Override
	public Boolean queryFrom(TemporalAccessor temporal) {
		
		LocalDate date = LocalDate.from(temporal);
		Month month = date.getMonth();
		int day = date.getDayOfMonth();
		
		Boolean result = false;
		
		switch(month){
		case JANUARY: 
			if ( day == 26) {
				return true;
			}
		
		case AUGUST:
			if ( day == 15 ) {
				return true;
			}
		default:
			return false;
		}
			
	}

}
