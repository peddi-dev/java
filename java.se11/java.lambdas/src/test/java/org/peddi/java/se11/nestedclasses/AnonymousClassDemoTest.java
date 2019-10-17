package org.peddi.java.se11.nestedclasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnonymousClassDemoTest {
    private final AnonymousClassDemo myApp = new AnonymousClassDemo();

    @Test
    void testSayHello() {
        System.out.println("***** AnonymousClassDemoTest");
        myApp.sayHello();
        assertTrue( true );
    }
}