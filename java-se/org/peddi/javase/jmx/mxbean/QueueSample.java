package org.peddi.javase.jmx.mxbean;

import java.time.LocalDate;
import java.beans.ConstructorProperties;

public class QueueSample {
	private final LocalDate date;
	private final int size;
	private final String head;
	
	@ConstructorProperties({"date", "size", "head"})
	public QueueSample(LocalDate date, int size, String head) {
		super();
		this.date = date;
		this.size = size;
		this.head = head;
	}
	public LocalDate getDate() {
		return date;
	}
	public int getSize() {
		return size;
	}
	public String getHead() {
		return head;
	}
	

}
