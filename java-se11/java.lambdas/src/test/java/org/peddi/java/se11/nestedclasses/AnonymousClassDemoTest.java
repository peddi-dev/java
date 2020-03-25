package org.peddi.java.se11.nestedclasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnonymousClassDemoTest {
    private final AnonymousClassDemo myApp = new AnonymousClassDemo();

    @Test
    public void testSayHello() {
        System.out.println("***** AnonymousClassDemoTest");
        myApp.sayHello();
        assertTrue( true );
    }
}