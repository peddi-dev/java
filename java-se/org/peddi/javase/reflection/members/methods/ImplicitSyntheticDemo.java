package org.peddi.javase.reflection.members.methods;

import java.lang.reflect.*;
import static java.lang.System.out;

public class ImplicitSyntheticDemo {
	
	final private static String fmt = "%n%24s: %s";
	
	class InnerClass {
		
	}
	
	enum Colors {
		RED,
		GREEN
	}
	
	public void implicitSyntheticDemo(String className) {
		
		try {
			Class<?> clsObj = Class.forName(className);
			printConstructors(clsObj);
			printDeclaredConstructors(clsObj);
			printMethods(clsObj);
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void printConstructors(Class clsObj) {
		
		Constructor<?>[] ctors = clsObj.getConstructors();
		out.printf(fmt, "Ctor Count", ctors.length);
		
		for(Constructor<?> c: ctors) {
			out.printf(fmt, "---Constructor" , c.toGenericString());
			Parameter[] params = c.getParameters();
			printParams(params);
		}
	}
	
	public void printDeclaredConstructors(Class clsObj) {
		Constructor<?>[] ctors = clsObj.getDeclaredConstructors();
		out.printf(fmt, "Declared Ctor Count", ctors.length);
		
		
		for(Constructor<?> c: ctors) {
			out.printf(fmt, "---Constructor" , c.toGenericString());
			Parameter[] params = c.getParameters();
			printParams(params);
		}
		
	}
	
	public void printMethods(Class clsObj) {
		
		Method[] methods = clsObj.getDeclaredMethods();
		out.printf(fmt, "Declared Method Count", methods.length);
		
		for(Method m: methods) {
			out.printf(fmt, "---Method" , m.toGenericString());
			out.printf(fmt, "IsSynthetic" , m.isSynthetic());
			Parameter[] params = m.getParameters();
			printParams(params);
		}
		
	}
	
	public void printParams(Parameter[] params) {
		
		for(Parameter p: params) {
	        out.format(fmt, "Parameter class", p.getType());
	        out.format(fmt, "Parameter name", p.getName());
	        out.format(fmt, "Modifiers", Modifier.toString(p.getModifiers()));
	        out.format(fmt, "Is implicit?", p.isImplicit());
	        out.format(fmt, "Is name present?", p.isNamePresent());
	        out.format(fmt, "Is synthetic?", p.isSynthetic());
		}
		
	}

	public static void main(String[] args) {
		
		
		ImplicitSyntheticDemo app = new ImplicitSyntheticDemo();
		String className = "org.peddi.javase.reflection.members.methods.ImplicitSyntheticDemo$Colors";
				//"org.peddi.javase.reflection.members.methods.ImplicitSyntheticDemo$InnerClass";
		app.implicitSyntheticDemo(className);
	}

}
