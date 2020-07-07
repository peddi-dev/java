package org.peddi.javase.reflection.members.methods;

import static java.lang.System.out;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.TypeVariable;
public class MethodsDemo {
	
	public void methodTypeInfoDemo(String clsName) {
		
		out.format("%n§§§methodTypeInfoDemo%n");
		
		try {
			
			Class<?> clsObj = Class.forName(clsName);
			Method[] methods = clsObj.getDeclaredMethods();
			
			for(Method m : methods) {
				
				out.format("%n----%s", m.toGenericString() );
				out.format("%n**Annotations");
				Annotation[] anns = m.getAnnotations();
				for(Annotation ann: anns) {
					out.format("%n%s", ann.annotationType());
				}
				
				out.format("%nModifiers: %s", Modifier.toString( m.getModifiers() ) );
				
				out.format("%n**GenericTypeParameters");
				TypeVariable<Method>[] tps = m.getTypeParameters();
				for(TypeVariable<Method> tp: tps) {
					out.format("%nGenericTypeParameter: %s", tp);
				}
				
				
				out.format("%nReturnType: %s", m.getReturnType().getCanonicalName());
				out.format("%nGenericReturnType: %s", m.getGenericReturnType());
				
				out.format("%n**Parameters");
				Parameter[] ps = m.getParameters();
				for(Parameter p: ps) {
					out.format("%nParamAnnotations");
					Annotation[] panns = p.getAnnotations();
					for(Annotation a: panns) {
						out.format("%n%s", a.annotationType());
					}
					out.format("%n%s   %s   %s", Modifier.toString( p.getModifiers() ), p.getType().getCanonicalName(), p.getName());
					
				}
				
				out.format("%n**ExceptionTypes");
				Class<?>[] es = m.getExceptionTypes();
				for(Class<?> e : es) {
					out.format("%n%s", e.getCanonicalName());
				}
				
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public void obtainMethodParameterNamesDemo(String className) {
		
		try {
			Class<?> clsObj = Class.forName(className);
			Method[] methods = clsObj.getDeclaredMethods();
			
			for(Method m: methods) {
				
				out.printf("%n%n-----Method:%s", m.getName());
				Parameter[] params = m.getParameters();
				
				for(Parameter p : params) {
					out.printf("%n%s", p.getName() );
				}
				
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		MethodsDemo app = new MethodsDemo();
		
		String clsName = "java.lang.Object";
		//app.methodTypeInfoDemo(clsName);
		
		clsName = "org.peddi.javase.reflection.members.methods.ExampleMethods";
		app.obtainMethodParameterNamesDemo(clsName);
		
	}

}
