package org.peddi.javase.io.scanningformatting;

import static java.lang.System.out;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class FormattingDemo {

	public void formattingDemo() {

		// String
		String str1 = "Java Language I/O API";
		out.format("%nString Data: %s", str1);

		// hashCode - returns Integer.toString(arg.hashCode())
		out.format("%nHashCode: %h", str1);

		// boolean
		boolean b = true;
		out.format("%nBoolean: %b", b);

		// decimal integer
		int i = 10500;
		out.format("%nDecimal integer: %d", i);

		int h = 10;
		out.format("%nHexaDecimal integer: 0x%x", h);

		// decimal integer with thousands separator(,)
		out.format("%nDemcimal with Thousands Separator: %,d", i);

		// floating point with precision
		out.format("%nFloating point with precision: %.3f", Math.PI);

		// scientific floating point
		out.format("%nScientific Floating point: %e", Math.PI);
		out.format("%nScientific Floating point: %E", Math.PI);
		out.format("%nScientific Floating point: %g", Math.PI);

		// time
		LocalDateTime dt = LocalDateTime.now();

		out.format("%nTime:  %tT", dt);
		out.format("%nDate(US):  %tD", dt);
		out.format("%nDate(ISO):  %tF", dt);

		ZonedDateTime zdt = ZonedDateTime.now();
		out.format("%nDate and Time:  %tc", zdt);

		out.println("\nDate and Time with Individual Fields");
		out.printf("%nTime: %1$tH:%1$tM:%1$tS %1$Tp %1$tZ", zdt);
		out.printf("%nDate: %1$ta, %1$td-%1$tb-%1$tY", zdt);
		// out.format("%n", args);

	}

	public static void main(String[] args) {
		FormattingDemo app = new FormattingDemo();
		app.formattingDemo();
	}

}
