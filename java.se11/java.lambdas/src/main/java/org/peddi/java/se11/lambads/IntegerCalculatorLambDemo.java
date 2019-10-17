package org.peddi.java.se11.lambads;

public class IntegerCalculatorLambDemo {

    private CalculatorDemo<Integer> intCal = new CalculatorDemo<Integer>();

    public Integer add(Integer d1, Integer d2){
        CalculatorDemo.ArithmaticOperation<Integer> op = ( a, b ) -> a + b;
        return intCal.operateBinary(d1, d2, op);
    }

    public Integer sub(Integer d1, Integer d2){
        CalculatorDemo.ArithmaticOperation<Integer> op = ( a, b ) -> a - b;
        return intCal.operateBinary(d1, d2, op);
    }

    public Integer multiply(Integer d1, Integer d2){
        CalculatorDemo.ArithmaticOperation<Integer> op = ( a, b ) -> a * b;
        return intCal.operateBinary(d1, d2, op);
    }


    public Integer divide(Integer d1, Integer d2){
        CalculatorDemo.ArithmaticOperation<Integer> op = ( a, b ) -> a / b;
        return intCal.operateBinary(d1, d2, op);
    }

    public Integer mod(Integer d1, Integer d2){
        CalculatorDemo.ArithmaticOperation<Integer> op = ( a, b ) -> a % b;
        return intCal.operateBinary(d1, d2, op);
    }

}
