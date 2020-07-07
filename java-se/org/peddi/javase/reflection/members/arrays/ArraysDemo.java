package org.peddi.javase.reflection.members.arrays;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;

import static java.lang.System.out;

public class ArraysDemo {

	public void identifyArrayDemo(String className) {
		out.println("******identifyArrayDemo");
		try {
			Class<?> clsObj = Class.forName(className);

			Field[] fields = clsObj.getDeclaredFields();

			for (Field f : fields) {
				Class<?> fType = f.getType();

				if (fType.isArray()) {
					out.format("%n%s %n%s %n%s %n%s", f, f.getName(), fType.getCanonicalName(),
							fType.getComponentType().getCanonicalName());
					out.println();
				}

			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	public void createArrayDemo(String className, int length) {
		out.println("\n******createArrayDemo");
		try {
			Class<?> arrayCompType = Class.forName(className);
			Object arrayObj = Array.newInstance(arrayCompType, length);
			out.println("New Array: " + arrayObj.getClass().getCanonicalName());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public void createMultiDimentionalArrayDemo() {
		out.println("\n******createMultiDimentionalArrayDemo");
		Object twoDArray = Array.newInstance(int.class, 2, 2);
		
		Object row0 = Array.get(twoDArray, 0);
		Object row1 = Array.get(twoDArray, 1);
		
		Array.setInt(row0, 0, 80);
		Array.setInt(row0, 1, 60);
		Array.setInt(row1, 0, 50);
		Array.setInt(row1, 1, 30);
		
		for(int i=0; i<2; i++) {
			
			for(int j=0; j<2; j++) {
				int elem = Array.getInt(Array.get(twoDArray, i), j);
				out.format("%ntwoDArray[%d][%d] = %d", i, j, elem );
			}
			
		}
		out.println();
		
	}

	public static void main(String[] args) {

		ArraysDemo app = new ArraysDemo();

		String className = "org.peddi.javase.reflection.members.arrays.SampleArrayClass";
		app.identifyArrayDemo(className);

		className = "java.lang.Integer";
		int length = 10;
		app.createArrayDemo(className, length);
		app.createMultiDimentionalArrayDemo();
		
		    Object ia = new int[2];
	        Array.setShort(ia, 0, (short)2);  // widening, succeeds -- storing short value in int array works fine
	        Array.setLong(ia, 1, 2L);         // narrowing, fails - storing long value in int array fails 
	}

}
