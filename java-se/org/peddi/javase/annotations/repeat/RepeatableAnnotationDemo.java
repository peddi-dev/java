package org.peddi.javase.annotations.repeat;

public class RepeatableAnnotationDemo {
	
	@Schedule(dayOfMonth="last")
	@Schedule(dayOfWeek="Fri", hour=23)
	public void process() {
		
	}

}
