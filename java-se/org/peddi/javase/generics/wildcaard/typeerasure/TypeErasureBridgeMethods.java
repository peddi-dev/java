package org.peddi.javase.generics.wildcaard.typeerasure;

public class TypeErasureBridgeMethods {
	
	public static void main(String[] args) {
		MyNode mn = new MyNode(10);
		Node n = mn;
		
		/**
		 * Exception in thread "main" java.lang.ClassCastException: class java.lang.String cannot be cast to class 
		 * java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
	     * at javase/org.peddi.javase.generics.wildcaard.typeerasure.MyNode.setData(MyNode.java:1)
	     * at javase/org.peddi.javase.generics.wildcaard.typeerasure.TypeErasureBridgeMethods.main(TypeErasureBridgeMethods.java:8)
		 */
		n.setData("hello");
		
	
	}
	

}
