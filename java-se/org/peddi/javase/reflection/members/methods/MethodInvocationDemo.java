package org.peddi.javase.reflection.members.methods;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInvocationDemo {

	public void privateMethodInvocationDemo(String className, String methodName) {

		try {
			Class<?> clsObj = Class.forName(className);

			Constructor<?> ctor = clsObj.getDeclaredConstructor();
			Object obj = ctor.newInstance();

			Method m = clsObj.getDeclaredMethod(methodName);
			// Note: Allows access to private method invocation
			m.setAccessible(true);

			m.invoke(obj);

		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

			e.printStackTrace();
		}
	}

	public void methodInvocationDemo(String className, String methodName) {
		try {

			Class<?> clsObj = Class.forName(className);

			Constructor<?> ctor = clsObj.getDeclaredConstructor();
			Object obj = ctor.newInstance();

			Method m = clsObj.getMethod(methodName);
			m.invoke(obj);

		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

			e.printStackTrace();
		}
	}

	public void methodWithParamsInvocationDemo(String className, String methodName) {

		try {

			Class<?> clsObj = Class.forName(className);

			Constructor<?> ctor = clsObj.getDeclaredConstructor();
			Object obj = ctor.newInstance();

			Class<?>[] paramTypes = new Class[] { String.class, String.class };
			Method m = clsObj.getMethod(methodName, paramTypes);

			Object[] args = new Object[] { "value1", "value2" };
			m.invoke(obj, args);

		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

			e.printStackTrace();
		}
	}

	public void methodWithVarArgsInvocationDemo(String className, String methodName) {

		try {

			Class<?> clsObj = Class.forName(className);

			Constructor<?> ctor = clsObj.getDeclaredConstructor();
			Object obj = ctor.newInstance();

			Class<?>[] paramTypes = new Class[] { String[].class };
			Method m = clsObj.getMethod(methodName, paramTypes);

			String[] args = new String[] { "arg1:val1", "arg2:val2", "arg3:val3" };
			m.invoke(obj, (Object) args);

		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		MethodInvocationDemo app = new MethodInvocationDemo();

		String className = "org.peddi.javase.reflection.members.methods.SampleMethods";
		String methodName = "sampleMethod";
		app.methodInvocationDemo(className, methodName);
		methodName = "sampleMethodWithParams";
		app.methodWithParamsInvocationDemo(className, methodName);
		methodName = "sampleMethodWithVarArgs";
		app.methodWithVarArgsInvocationDemo(className, methodName);

		methodName = "privateMethod";
		app.privateMethodInvocationDemo(className, methodName);

	}

}
