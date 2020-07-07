package org.peddi.javase.reflection.classes;

import static java.lang.System.out;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class ClassesDemo {
	
	enum Option {
		Yes,
		No
	}
	
	public void getClassDemo() {
		
		out.println("\ngetClassDemo() ");
		
		//Error: Cannot invoke getClass() on primitive type boolean
		//boolean b = true;
		//Class bc = b.getClass();
		
		// instance of reference type
		String name = "John";
		Class<? extends String> stringClass = name.getClass();
		out.println("String intance.getClass():" + stringClass);
		
		//instance of enum
		Option choice = Option.No;
		Class<? extends Option> ec = choice.getClass();
		out.println("enum getClass(): " + ec);
		
		// primitive type array
		byte[] ba = new byte[100];
		Class<? extends byte[]> bac = ba.getClass();
		out.println("byte[] instance getClass(): " + bac);
		
		short[] sa = new short[10];
		Class<? extends short[]> sac = sa.getClass();
		out.println("short[] instance getClass(): " + sac);
		
		long[] la = new long[10];
		Class<? extends long[]> lac = la.getClass();
		out.println("short[] instance getClass(): " + lac);
		
		// reference type array
		ClassesDemo[] cda = new ClassesDemo[10];
		Class<? extends ClassesDemo[]> cdac = cda.getClass();
		out.println("ClassesDemo[] instance getClass(): " + cdac);
		
		//java.util.Set and java.uitl.HashSet
		Set<String> ss = new HashSet<>();
		Class<?> ssc = ss.getClass();
		out.println("Set with HashSet instance getClass(): " + ssc);
	}
	
	
	public void dotClassDemo() {
		out.println("\ndotClassDemo()");
		
		// primitive type
		Class<Boolean> bc = boolean.class;
		out.println("boolean.class :  " + bc);
		
		// reference type
		Class<PrintStream> psc = java.io.PrintStream.class;
		out.println("java.io.PrintStream.class :  " + psc);
		
		// array
		Class<long[][][]> iac = long[][][].class;
		out.println("int[][][].class :  " + iac);
		
		
		Class<ClassesDemo[][]> cdc = ClassesDemo[][].class;
		out.println("ClassesDemo[][].class :  " + cdc);
		
	}
	
	public void classForNameDemo() {
		
		out.println("\nclassForNameDemo()");
		
		try {
			
			// reference type
			Class<?> cdc = Class.forName("org.peddi.javase.reflection.ClassesDemo");
			out.println("forName(org.peddi.javase.reflection.ClassesDemo) :" + cdc);
			 
			// primitive array
			Class<?> cLongArray = Class.forName("[J");
			out.println("long array - forName([J) : " + cLongArray);
			
			// reference type array
			Class<?> cStringArray = Class.forName("[Ljava.lang.String;");
			
			out.println("String array - forName([java.lang.String;) : " + cStringArray);
			
		} catch (ClassNotFoundException e) {
			 
			e.printStackTrace();
		}
		
	}
	
	public void TYPEFieldForPrimitiveTypeWrappersDemo() {
		
		out.println("\nTYPEFieldForPrimitiveTypeWrappersDemo()");
		out.println("Character.TYPE : "  + Character.TYPE);
		out.println("Byte.TYPE : "  + Byte.TYPE);
		out.println("Short.TYPE : "  + Short.TYPE);
		out.println("Integer.TYPE : "  + Integer.TYPE);
		out.println("Long.TYPE : "  + Long.TYPE);
		out.println("Float.TYPE : "  + Float.TYPE);
		out.println("Void.TYPE : "  + Void.TYPE);
		
	}
	
	
	class MyClass {
		 
		 Object anonymousObj = new Object() {
			 public void m() {}
		 };
		
		 public Object getAnonymousObj() {
			 return anonymousObj;
		 }
		 public void demo() {
			 out.println("\nInner class MyClass");
			 out.println("Declaring Class of Annonymous class :" + anonymousObj.getClass().getDeclaringClass());
			 out.println("Enclosing Class of Annonymous class :" + anonymousObj.getClass().getEnclosingClass());
			 
		 }
	}
	
	public void methodThatReturnClassesDemo() {
		out.println("\nmethodThatReturnClassesDemo()");
		out.println("Class.getSuperClass(): " + org.peddi.javase.reflection.classes.ClassesDemo.class.getSuperclass() );
		out.println("\nCharacter.class.getClasses(): ");
		Class<?>[] cs = Character.class.getClasses();
		for (Class<?> c : cs ) {
			out.println(c);
			
		}
		
		out.println("\nCharacter.class.getDeclaredClasses(): ");
		Class<?>[] cs2 = Character.class.getDeclaredClasses();
		for (Class<?> c : cs2 ) {
			out.println(c);
			
		}
		
		Field f;
		try {
			f = System.class.getField("out");
			Class<?> dc = f.getDeclaringClass();
			out.println("getDeclaringClass() - System.out Field :" + dc);
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Method method = ClassesDemo.class.getMethod("getClassDemo", (Class<?>[])null);
			Class<?> mc = method.getDeclaringClass();
			out.println("getDeclaringClass() - Method :" + mc);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		Class<?> ec = Thread.State.class.getEnclosingClass();
		out.println("hread.State.class.getEnclosingClass(): " + ec);
		
		
		//Local Anonymous
		Object anonymousObj = new Object() {
			 public void m() {}
		 };
		 
		 out.println("\nLocal Anonymous");
		 out.println("Declaring Class of Annonymous class :" + anonymousObj.getClass().getDeclaringClass());
		 out.println("Enclosing Class of Annonymous class :" + anonymousObj.getClass().getEnclosingClass());
		 out.println("Enclosing Class of Annonymous class :" + anonymousObj.getClass().getEnclosingMethod());
		 
		 
		 //Inner Anonymous
		 MyClass myc = new MyClass();
		 myc.demo();
		
		
	}

	public static void main(String[] args) {
		ClassesDemo app = new ClassesDemo();
		//app.getClassDemo();
		//app.dotClassDemo();
		//app.classForNameDemo();
		//app.TYPEFieldForPrimitiveTypeWrappersDemo();
		app.methodThatReturnClassesDemo();

	}

}
