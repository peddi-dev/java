package org.peddi.java.se11.lambads;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.peddi.java.se11.lambads.DataSearchLambdaDemo.Filter;

class DataSearchLambdaDemoTest {

    private final DataSearchLambdaDemo myApp = new DataSearchLambdaDemo(null);

    @Test
    void searchPersonsWithLocalFilter() {


        myApp.searchPersonsWithLocalFilter();
        assertTrue(true);
    }


    @Test
    void searchPersonsWithAnonymousFilter() {

        myApp.searchPersonsWithAnonymousFilter();
        assertTrue(true);
    }


    @Test
    void searchPersonsWithLambdaExpressionFilter() {

        myApp.searchPersonsWithLambdaExpressionFilter();

        assertTrue(true);
    }


    @Test
    void searchPersonsWithPredicate() {

        myApp.searchPersonsWithPredicate();
        assertTrue(true);
    }

    @Test
    void searchPersonsWithPredicateFunctionConsumer() {

        myApp.searchPersonsWithPredicateFunctionConsumer();
        assertTrue(true);
    }

    @Test
    void processPersonsUsingAggregateOperationsWithLambdaExpressions(){
        myApp.processPersonsUsingAggregateOperationsWithLambdaExpressions();
        assertTrue(true);
    }




}
