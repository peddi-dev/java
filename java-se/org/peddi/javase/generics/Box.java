package org.peddi.javase.generics;

/**
 * 
 * @author peddi
 *
 * @param <T> - T is type parameter
 */
		
public class Box<T> {
	
	T item;
	
	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	Box(){
		
	}
	
	Box(T b){
		this.item = b;
	}

}


