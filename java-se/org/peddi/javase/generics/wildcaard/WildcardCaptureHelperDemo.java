package org.peddi.javase.generics.wildcaard;
import java.util.*;

public class WildcardCaptureHelperDemo {
	
	void foo(List<?> i) {
		
		
		// Following statement gives error, hence helper method is used 
		//i.set(0, i.get(0));
		fooHelper(i);
	}
	
	private <T> void fooHelper(List<T> i) {
		i.set(0, i.get(0));
	}
	
	public static void main(String[] args) {
		WildcardCaptureHelperDemo app = new WildcardCaptureHelperDemo();
		List<Integer> data = new ArrayList<>();
		data.add(5);
		data.add(8);
		app.foo(data);
		
	}

}
