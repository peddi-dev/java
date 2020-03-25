package org.peddi.java.se13.switchexpr;

import org.peddi.java.se13.common.Day;

/**
 * Switch Expression
 * 
 */
public class SwitchExpressionDemo 
{
    /**
     * Switch with arrow label 
     * Switch expression returns the value in this example
     * @param d
     * @return
     */
    public int charCountInDayOfWeek(Day d){

        return switch(d){
            case SUNDAY, MONDAY, FRIDAY -> Day.SUNDAY.toString().length();
            case TUESDAY -> Day.TUESDAY.toString().length();
            case THURSDAY,SATURDAY -> Day.THURSDAY.toString().length();
            case WEDNESDAY -> Day.WEDNESDAY.toString().length();

        };
    }

    /**
     * yield statement in switch expression
     * default clause required in switch expression, in case of enums compiler inserts the default clause
     */
    public int switchWithYield(String s){
        return switch (s) {

            case "Foo": 
                yield 1;
            case "Bar":
                yield 2;
            default:
                System.out.println("Neither Foo nor Bar, hmmm...");
                yield 0;

        };
        
    }

}
