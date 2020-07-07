package org.peddi.javase.concurrency.singlton;

public class Singleton {

	private static volatile Singleton obj = null;

	private  Singleton() {
		
	}
	
	private synchronized static void createObject() {
		
		if (obj == null) {
			obj = new Singleton();
		}
		
	}

	public static Singleton getInstance() {

		if (obj != null) {
			return obj;
		}
		
		
		createObject();

//		synchronized (Singleton.class) {
//
//			if (instance == null) {
//				instance = new Singleton();
//			}
//
//		}
		
		return obj;

	}
	
	
	public static void main(String[] args) {
		System.out.println(Singleton.getInstance());
	}
}
