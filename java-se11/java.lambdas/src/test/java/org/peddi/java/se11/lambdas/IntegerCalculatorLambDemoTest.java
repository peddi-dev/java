package org.peddi.java.se11.lambdas;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerCalculatorLambDemoTest {


    private  final IntegerCalculatorLambDemo myApp = new IntegerCalculatorLambDemo();

    @BeforeAll
    public static  void initialize(){
        System.out.print("****** IntegerCalculatorLambDemoTest");
    }


    @Test
    public void add() {

        System.out.println("Add: " + myApp.add(20, 10));
    }

    @Test
    public void sub() {
        System.out.println("Sub: " + myApp.sub(20, 10));
    }

    @Test
    public void multiply() {
        System.out.println("Multiply: " + myApp.multiply(20, 10));
    }

    @Test
    public void divide() {
        System.out.println("Divide: " + myApp.divide(20, 10));
    }

    @Test
    public void mod() {
        System.out.println("Mod: " + myApp.mod(20, 10));
    }
}