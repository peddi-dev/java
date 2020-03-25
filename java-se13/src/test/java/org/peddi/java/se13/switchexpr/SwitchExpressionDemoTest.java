package org.peddi.java.se13.switchexpr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import org.peddi.java.se13.common.Day;

public class SwitchExpressionDemoTest{

    
    @Test
    public void testCharCountInDayOfWeek() {
        SwitchExpressionDemo app = new SwitchExpressionDemo();
        Day inputDay = Day.SUNDAY;
        int actualCount =  inputDay.toString().length(); 
        int expectedCount = app.charCountInDayOfWeek(inputDay);
        System.out.format("==>charCountInDayOfWeek() for %s : %d \n" , inputDay, expectedCount);
        assertEquals("Char Count is Incorrect", expectedCount, actualCount);
    }


    @Test
    public void testSwitchWithYield(){
        SwitchExpressionDemo app = new SwitchExpressionDemo();
        int count = app.switchWithYield("Foo");
        System.out.println("==>SwitchWithYield: " + count);
        assertEquals("==>Char Count is Incorrect", count, 1);

    }

}