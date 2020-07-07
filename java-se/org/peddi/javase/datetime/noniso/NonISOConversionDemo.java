package org.peddi.javase.datetime.noniso;

import java.time.LocalDateTime;
import java.time.chrono.HijrahDate;
import java.time.chrono.JapaneseDate;
import java.time.chrono.MinguoDate;
import java.time.chrono.ThaiBuddhistDate;

import static java.lang.System.out;

public class NonISOConversionDemo {
	
	
	public void nonISOConversionDemo() {
		LocalDateTime isoDate = LocalDateTime.now();
		JapaneseDate japaneseDate = JapaneseDate.from(isoDate);
		HijrahDate islamicDate = HijrahDate.from(isoDate);
		MinguoDate chineseDate = MinguoDate.from(isoDate);
		ThaiBuddhistDate buddistDate = ThaiBuddhistDate.from(isoDate);
		
		out.println("nonISOConversionDemo()");
		out.printf("ISO Date: %s%n", isoDate);
		out.printf("Islamic Date: %s%n", islamicDate);
		out.printf("Japanese Date: %s%n", japaneseDate);
		out.printf("Chinese Date: %s%n", chineseDate);
		out.printf("Buddhist Date: %s%n", buddistDate);
		
	}
	
	public static void main(String[] args) {
		NonISOConversionDemo app = new NonISOConversionDemo();
		app.nonISOConversionDemo();
				
	}

}
