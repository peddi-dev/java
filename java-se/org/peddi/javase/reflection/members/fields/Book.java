package org.peddi.javase.reflection.members.fields;

public class Book {
	
	public String title = "Effective Java";
	protected String isbn = "123-456-789";
	private long copies = 10;
	String publisher = "Manning";
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public long getCopies() {
		return copies;
	}
	public void setCopies(long copies) {
		this.copies = copies;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

}
