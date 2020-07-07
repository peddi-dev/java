package org.peddi.javase.reflection.classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NewInstanceDemo {
	
	public void newInstanceDemo() {
		
		
		Class<String> clo = java.lang.String.class;
		
		try {
			Constructor<String> ctor = clo.getDeclaredConstructor(char[].class);
			char[] ca = {'s','a','m','p','l','e'};
			String newStringObj = ctor.newInstance(ca);
			System.out.println("New String Object is :" +  newStringObj );
		} catch (NoSuchMethodException e) {
			 
			e.printStackTrace();
		} catch (SecurityException e) {
			 
			e.printStackTrace();
		} catch (InstantiationException e) {
			 
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			 
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			 
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			 
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
		NewInstanceDemo app = new NewInstanceDemo();
		app.newInstanceDemo();
	}

}
