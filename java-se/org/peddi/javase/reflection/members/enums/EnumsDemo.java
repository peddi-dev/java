package org.peddi.javase.reflection.members.enums;
import static java.lang.System.out;

import java.lang.reflect.Field;
import java.util.Arrays;

public class EnumsDemo {
	
	public void examinEnumsDemo(String enumClassName) {
		
		out.println("\n****examinEnumsDemo()");
		
		try {
			Class<?> enumClassObj = Class.forName(enumClassName);
			Object[] enums = enumClassObj.getEnumConstants();
			
			out.printf("%s", Arrays.asList(enums));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getAndSetEnums(String level) {
		out.println("\n\n****getAndSetEnums()");
		SampleApp serverApp = new SampleApp();
		
		Class<?> classObj = serverApp.getClass();
		
		try {
			
			
			Field fl = classObj.getDeclaredField("level");
			fl.setAccessible(true);
			TraceLevel oldLevel = (TraceLevel) fl.get(serverApp);
			TraceLevel newLevel = TraceLevel.valueOf(level);
			
			if(oldLevel != newLevel) {
				
				fl.set(serverApp, newLevel);
				
				out.printf(" oldLevel: %s, newLevl:%s%n", oldLevel, newLevel);
			}else {
				out.println("Level not changed");
			}
			
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
		EnumsDemo app = new EnumsDemo();
		String enumClassName = "org.peddi.javase.reflection.members.enums.WeekDay";
		
		app.examinEnumsDemo(enumClassName);
		
		enumClassName = "java.lang.annotation.RetentionPolicy";
		app.examinEnumsDemo(enumClassName);
		
		app.getAndSetEnums(TraceLevel.DEBUG.toString());
		
		

	}

}
