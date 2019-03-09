package org.peddi.java.se11.nestedclasses;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InnerClassDemoTest {
	private final InnerClassDemo ds = new InnerClassDemo();

	@Test
	public void testPrintEven() {
      // Fill the array with integer values and print out only
      // values of even indices

	  System.out.println("**** InnerClassDemoTest");
      ds.printEven();
      assertTrue( true );
	}

}
