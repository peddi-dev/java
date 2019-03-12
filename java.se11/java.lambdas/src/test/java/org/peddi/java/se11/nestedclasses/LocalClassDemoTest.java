package org.peddi.java.se11.nestedclasses;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class LocalClassDemoTest  {

	@Test
	public void testValidatePhoneNumbers(){
		System.out.println("*** LocalClassDemoTest ");
		LocalClassDemo.validatePhoneNumber("123-456-7890", "456-7890");
		assertTrue( true );
	}

}