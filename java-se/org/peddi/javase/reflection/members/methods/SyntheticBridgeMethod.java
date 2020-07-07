package org.peddi.javase.reflection.members.methods;

import static java.lang.System.out;

import java.lang.reflect.Method;

public class SyntheticBridgeMethod {
	
	final private String fmt = "%n%24s: %s";
	
	public void syntheticBridgeMethodDemo(String className, String methodName) {
		
		Class<?> clsObj;
		try {
			clsObj = Class.forName(className);
			Method[] methods = clsObj.getDeclaredMethods();
			
			for(Method m: methods) {
				if( !m.getName().equals(methodName)) {
					continue;
				}
				out.printf(fmt,"Method", m.toGenericString());
				out.printf(fmt,"IsSyntheticMethod", m.isSynthetic());
				out.printf(fmt, "IsBridgeMethod", m.isBridge());
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}	
	}
	
	
	public static void main(String[] args) {
		SyntheticBridgeMethod app = new SyntheticBridgeMethod();
		String className = "java.lang.String";
		String methodName = "compareTo";
		app.syntheticBridgeMethodDemo(className, methodName);
	}

}
