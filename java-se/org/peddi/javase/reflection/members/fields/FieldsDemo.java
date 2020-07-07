package org.peddi.javase.reflection.members.fields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import static java.lang.System.out;
public class FieldsDemo <T> {
	
	public boolean[][] b = {{ false, false }, { true, true } };
    private String name  = "Alice";
    protected List<Integer> list;
    public T val;
    final private static  int si = 10;

	public void fieldTypesDemo(String clsName, String fldName) {
		
		out.println("§§§fieldTypesDemo()");
		
		try {
			
			Class<?> clsObj = Class.forName(clsName);
			
			Field[] fs = null;
			if ( fldName == null || fldName.isEmpty()) {
				fs = clsObj.getFields();
			}else {
				Field f = clsObj.getField(fldName);
				fs = new Field[] {f};
			}
			
			if ( fs.length == 0) {
				out.println("--None--");
			}
			
			for(Field f : fs) {
				out.printf("Field: %s, Type: %s, GenericType: %s%n", f.getName(), f.getType(), f.getGenericType());
			}
			
			
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException e) {
			
			e.printStackTrace();
		}
		 
	}
	
	public void fieldModifiersDemo(String clsName) {
		
		out.println("\n§§§fieldModifiersDemo");
		
		try {
			Class<?> clsObj = Class.forName(clsName);
			
			Field[] fs = clsObj.getDeclaredFields();
			
			for(Field f : fs) {
				out.printf("Field: %s, Modifiers: %s%n", f.getName(), Modifier.toString( f.getModifiers() ) );
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public void getAndSetFieldValuesDemo(String clsName) {
		out.println("\n§§§getAndSetFieldValuesDemo");
		
		try {
			Book book = new Book();
			Class<?> clsObj = Class.forName(clsName);
			Field f = clsObj.getDeclaredField("copies");
			/**
			 * enables access to private members
			 */
			f.setAccessible(true);
			out.printf("Class: %s, Field: %s, Before Value: %d%n", clsObj.getName() ,f.getName(), f.getLong(book)  );
			
			if ( f.canAccess(book) ) {
				f.setLong(book, 20);
			}
			out.printf("Class: %s, Field: %s, After  Value: %d%n",  clsObj.getName(),  f.getName(), f.getLong(book)  );
			
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		FieldsDemo<?> app = new FieldsDemo<>();
		String clsName = "org.peddi.javase.reflection.members.fields.FieldsDemo";
				//"java.lang.Exception";
				//"java.lang.String";
		String fldName = null;
		//"CASE_INSENSITIVE_ORDER";
//		app.fieldTypesDemo(clsName, fldName);
//		app.fieldModifiersDemo(clsName);
		
		String clsName2 = "org.peddi.javase.reflection.members.fields.Book";
		app.getAndSetFieldValuesDemo(clsName2);
	}
}
