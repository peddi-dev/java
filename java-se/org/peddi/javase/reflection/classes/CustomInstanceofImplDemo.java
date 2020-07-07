package org.peddi.javase.reflection.classes;



public class CustomInstanceofImplDemo {
	
	public boolean isInstanceOf(Object obj) {
		
		
		
		return CustomInstanceofImplDemo.class.isInstance(obj);
		
	}

	public static void main(String[] args) {
		CustomInstanceofImplDemo app = new CustomInstanceofImplDemo();
		boolean result = app.isInstanceOf(app);
		System.out.println(result);
		
		result = app.isInstanceOf(new Object());
		System.out.println(result);

	}

}
