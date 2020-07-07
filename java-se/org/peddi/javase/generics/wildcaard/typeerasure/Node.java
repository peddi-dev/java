package org.peddi.javase.generics.wildcaard.typeerasure;

public class Node<T> {
	
	public T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node(T data) {
		super();
		this.data = data;
	}
	

}
