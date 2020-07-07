package org.peddi.javase.reflection.members.methods;

import static java.lang.System.out;

public class SampleMethods {
	
	private void privateMethod() {
		out.println("....privateMethod()");
	}
	
	public void sampleMethod() {
		out.println("....sampleMethod()");
	}
	
	public void sampleMethodWithParams(String param1, String param2) {
		
		out.println("....sampleMethodWithParams(String param1, String param2)");
		out.println("	Param1: "+ param1);
		out.println("	Param2: "+ param2);
	}
	
	public void sampleMethodWithVarArgs(String... args) {
		
		out.println("....sampleMethodWithVarArgs(String... args)");
		
		for(String a: args) {
			out.format("	%s%n", a);
		}
		
	}

}
