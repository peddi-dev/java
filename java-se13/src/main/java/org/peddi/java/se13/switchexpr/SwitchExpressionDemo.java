package org.peddi.java.se13.switchexpr;

import org.peddi.java.se13.common.Day;

/**
 * Switch Expression
 *
 */
public class SwitchExpressionDemo 
{
    /**
     * Switch expression returns the value in this example
     * @param d
     * @return
     */
    public int charCountInDayOfWeek(Day d){

        return switch(d){
            case SUNDAY, MONDAY, FRIDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY,SATURDAY -> 8;
            case WEDNESDAY ->9;

        };
    }

    /**
     * yield statement in switch expression
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
