package org.peddi.java.se11.lambdas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.peddi.java.se11.lambdas.DataSearchLambdaDemo.Filter;

public class DataSearchLambdaDemoTest {

    private final DataSearchLambdaDemo myApp = new DataSearchLambdaDemo(null);

    @Test
    public void searchPersonsWithLocalFilter() {


        myApp.searchPersonsWithLocalFilter();
        assertTrue(true);
    }


    @Test
    public void searchPersonsWithAnonymousFilter() {

        myApp.searchPersonsWithAnonymousFilter();
        assertTrue(true);
    }


    @Test
    public void searchPersonsWithLambdaExpressionFilter() {

        myApp.searchPersonsWithLambdaExpressionFilter();

        assertTrue(true);
    }


    @Test
    public void searchPersonsWithPredicate() {

        myApp.searchPersonsWithPredicate();
        assertTrue(true);
    }

    @Test
    public void searchPersonsWithPredicateFunctionConsumer() {
        myApp.searchPersonsWithPredicateFunctionConsumer();
        assertTrue(true);
    }

    @Test
    public void processPersonsUsingAggregateOperationsWithLambdaExpressions(){
        myApp.processPersonsUsingAggregateOperationsWithLambdaExpressions();
        assertTrue(true);
    }
}
