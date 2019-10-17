package org.peddi.java.se11.nestedclasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocalClassDemo2Test {
    private final LocalClassDemo2 myApp = new LocalClassDemo2();

        @Test
        public void testSayGoodbyeInEnglishValidatePhoneNumbers(){
            System.out.println("**** LocalClassDemo2Test");
            myApp.sayGoodbyeInEnglish();
            assertTrue( true );
        }

}
