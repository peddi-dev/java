package org.peddi.javase.reflection.classes;


import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class ClassModifiersAndTypesDemo {
	
	
	public void classModifiersAndTypesDemo(String name) {
		out.printf("%n====classModifiersAndTypesDemo(): %n");
		try {
			
			Class<?> classObj = Class.forName(name);
			out.printf("%n***Class: %s %n",  classObj.getCanonicalName());
			
			out.printf("%n***Modifiers: %n%s %n", Modifier.toString( classObj.getModifiers() ) );
			
			out.printf("%n***Type Parametrs: %n");
			TypeVariable<?>[] tva = classObj.getTypeParameters();
			
			if (tva.length == 0) {
				out.print("--None--");
			}else {
				for(TypeVariable<?> tv: tva) {
					out.printf("%s ", tv.getName());
				}
			}
			
			out.printf("%n%n***Implemented Interfaces%n");
			Type[] types = classObj.getGenericInterfaces();
			if(types.length == 0){
				out.println("--None--");
			}else {
				for(Type t : types) {
					out.printf("%s%n", t.getTypeName());
				}
			}
			
			out.printf("%n%n***Inheritance Path - getSuperClass()%n");
			List<Class<?>> inherits = new ArrayList<>();
			Class<?> parent = classObj.getSuperclass();
			
			while(parent != null) {
				inherits.add(parent);
				parent = parent.getSuperclass();
			}
			if( inherits.size() == 0 ) {
				out.print("--None--");
			}else {
				for(Class<?> p: inherits) {
					out.printf("%s%n", p.getCanonicalName());
				}
			}
			
			out.printf("%n%n***Annotations%n");
			Annotation[] annotations = classObj.getAnnotations();
			if( annotations.length == 0 ) {
				out.print("--None--");
			}else {
				for(Annotation a: annotations) {
					out.printf("%s%n", a);
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		
		ClassModifiersAndTypesDemo app = new ClassModifiersAndTypesDemo();
		String className = "java.security.Identity";
		app.classModifiersAndTypesDemo(className);
		String className2 = "[Ljava.lang.String;";
		try {
			Class<?> clo = Class.forName(className2);
			out.println("&&&&&&" +clo.getCanonicalName());
		} catch (ClassNotFoundException e) {
			 
			e.printStackTrace();
		}
		
		app.classModifiersAndTypesDemo(className2);
		String className3 = "java.util.concurrent.ConcurrentNavigableMap";
		app.classModifiersAndTypesDemo(className3);
		
	}

}
