package org.peddi.javase.reflection.classes;

import static java.lang.System.out;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * getDeclaredxxx() methods return all members including private 
 * in the class represented by the class object, but does not 
 * return the inherited members
 * 
 * 
 * @author peddi
 *
 */
public class ClassDeclaredMembersDemo {


	
	public void classMembersDemo(String name) {
		
		out.println("§§§§classMembersDemo()");
		
		try {
			Class<?> clObj = Class.forName(name);
			out.printf("%n%nClass: %s", clObj.getCanonicalName());
			out.printf("%n%nPackage: %s", clObj.getPackage());
			
			for(ClassMember m: ClassMember.values()) {
				switch(m) {
				case Constructor:
					discoverConstructors(clObj);
					break;
				case Field: 
					 discoverFields(clObj);
					 break;
				case Method: 
					 discoverMethods(clObj);
					 break;
				case Class: 
					 discoverClasses(clObj);
					 break;					 
				default:
					assert false;
				}
					
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	
	private void discoverConstructors(Class<?> clObj) {
		Constructor<?>[] list = clObj.getDeclaredConstructors();
		out.printf("%n%nCtors%n");
		
		if(list.length == 0) {
			out.printf("--None--");
			return;
		}
		
		for(Constructor<?> item : list) {
			out.printf("%s%n", item.toGenericString());
		}
	}
	private void discoverFields(Class<?> clObj) {
		Field[] list = clObj.getDeclaredFields();
		out.printf("%n%nFields%n");
		
		if(list.length == 0) {
			out.printf("--None--");
			return;
		}
		
		for(Field item : list) {
			out.printf("%s%n", item.toGenericString());
		}	
	}
	private void discoverMethods(Class<?> clObj) {
		Method[] list = clObj.getDeclaredMethods();
		out.printf("%n%nMethods%n");
		
		if(list.length == 0) {
			out.printf("--None--");
			return;
		}
		
		for(Method item : list) {
			out.printf("%s%n", item.toGenericString());
		}
	}
	private void discoverClasses(Class<?> clObj) {
		clObj.getClasses();
		Class<?>[] list = clObj.getDeclaredClasses();
		out.printf("%n%nClasses%n");
		
		if(list.length == 0) {
			out.printf("--None--");
			return;
		}
		
		for(Class<?> item : list) {
			out.printf("%s%n", item.toGenericString());
		}
	}

	public static void main(String[] args) {
		
		ClassDeclaredMembersDemo app = new ClassDeclaredMembersDemo();
		String className = "java.lang.String";
				//"org.peddi.javase.reflection.classes.ClassMembersDemo$ClassMember";
				//"java.nio.channels.ReadableByteChannel";
				//"java.lang.ClassCastException";
		app.classMembersDemo(className);

	}

}
