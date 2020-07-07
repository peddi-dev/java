package org.peddi.javase.datetime.parsingformating;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class ParsingDemo {
	
	public void parsingDemo() {
		String date = "19590705";
		LocalDate ld1 = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(ld1);
	}
	
	public void parsingWithCustomFormatDemo() {
		
		String date = "Apr 10 2019";
		try {
			
			DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("MMM d yyyy");
			LocalDate d1 = LocalDate.parse(date, customFormatter);
			System.out.println("Custom Formatter MMM d yyyy : " + d1);
			
		}catch(DateTimeParseException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ParsingDemo app = new ParsingDemo();
		app.parsingDemo();
		app.parsingWithCustomFormatDemo();

	}

}
