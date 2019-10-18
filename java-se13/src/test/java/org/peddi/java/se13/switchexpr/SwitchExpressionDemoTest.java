package org.peddi.java.se13.switchexpr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import org.peddi.java.se13.common.Day;



public class SwitchExpressionDemoTest{

    
    @Test
    public void testCharCountInDayOfWeek() {
        SwitchExpressionDemo app = new SwitchExpressionDemo();
        int count = app.charCountInDayOfWeek(Day.SUNDAY);
        System.out.println("charCountInDayOfWeek: " + count);
        assertEquals("Char Count is Incorrect", count, 6);
    }


    @Test
    public void testSwitchWithYield(){
        SwitchExpressionDemo app = new SwitchExpressionDemo();
        int count = app.switchWithYield("Foo");
        System.out.println("SwitchWithYield: " + count);
        assertEquals("Char Count is Incorrect", count, 1);

    }

}