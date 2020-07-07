package org.peddi.javase.datetime.parsingformating;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDemo {
	
	
	public void formatDemo() {
		
		
		LocalDateTime dateTime = LocalDateTime.of(2019, 4, 10, 20, 30);
		try {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy h:m a");
			String dateTimeString = dateTime.format(formatter);
			System.out.println("Formatted Date Time with MMM d yyyy h:m a : "+ dateTimeString);
			
			
		}catch(DateTimeException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		FormatDemo app = new FormatDemo();
		app.formatDemo();
	}

}
