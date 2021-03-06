package org.peddi.java.se11.lambdas.defaultmethods;

import org.junit.jupiter.api.Test;
import org.peddi.java.se11.lambdas.DataSearchLambdaDemo;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultMethodDemoTest {
    private final DefaultMethodDemo app = new DefaultMethodDemo();

    @Test
    public void  sortPersonsUsingDefaultMethod(){
        System.out.println("***** DefaultMethodDemoTest");
        DataSearchLambdaDemo data = new DataSearchLambdaDemo();
        app.sortPersonsUsingDefaultMethod(data.getMembers());

    }

    @Test
    public void  sortPersonsUsingListSortDefaultMethodAndMethodReference(){
        System.out.println("***** DefaultMethodDemoTest");
        DataSearchLambdaDemo data = new DataSearchLambdaDemo();
        app.sortPersonsUsingListSortDefaultMethodAndMethodReference(data.getMembers());

    }


}